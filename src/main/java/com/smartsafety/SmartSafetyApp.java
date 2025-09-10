package com.smartsafety;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsafety.models.Alert;
import com.smartsafety.models.User;
import com.smartsafety.repositories.AlertRepository;
import com.smartsafety.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class SmartSafetyApp {

    public static void main(String[] args) {
        SpringApplication.run(SmartSafetyApp.class, args);
    }

    /**
     * Loads sample synthetic_data.json from resources (if present) and inserts into MongoDB.
     * Safe: will not duplicate records across restarts if IDs are not provided (keeps duplicates minimal).
     */
    @Bean
    CommandLineRunner loadData(UserRepository userRepo, AlertRepository alertRepo,
                               @Value("${app.data.load:true}") boolean loadData) {
        return args -> {
            if (!loadData) return;
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream is = getClass().getResourceAsStream("/data/synthetic_data.json")) {
                if (is == null) return;
                var tree = mapper.readTree(is);
                if (tree.has("users")) {
                    List<User> users = mapper.convertValue(tree.get("users"), new TypeReference<List<User>>() {});
                    for (User u : users) {
                        // avoid duplicating by email
                        if (u.getEmail() != null && userRepo.findByEmail(u.getEmail()).isPresent()) continue;
                        userRepo.save(u);
                    }
                }
                if (tree.has("alerts")) {
                    List<Alert> alerts = mapper.convertValue(tree.get("alerts"), new TypeReference<List<Alert>>() {});
                    for (Alert a : alerts) {
                        if (a.getCreatedAt() == null) a.setCreatedAt(Instant.now());
                        alertRepo.save(a);
                    }
                }
            } catch (Exception ex) {
                System.err.println("Failed to load synthetic data: " + ex.getMessage());
            }
        };
    }
}
