package com.smartsafety.services;

import com.smartsafety.models.User;
import com.smartsafety.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User register(User user, String password) {
        user.setPasswordHash(encoder.encode(password));
        return userRepo.save(user);
    }

    public User authenticate(String email, String password) {
        return userRepo.findByEmail(email)
                .filter(u -> encoder.matches(password, u.getPasswordHash()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public List<User> listAll() {
        return userRepo.findAll();
    }
}
