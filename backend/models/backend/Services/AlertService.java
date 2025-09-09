package com.smartsafety.services;

import com.smartsafety.models.Alert;
import com.smartsafety.repositories.AlertRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertService {
    private final AlertRepository alertRepo;

    public AlertService(AlertRepository alertRepo) {
        this.alertRepo = alertRepo;
    }

    public Alert createAlert(Alert alert) {
        return alertRepo.save(alert);
    }

    public List<Alert> getAll() {
        return alertRepo.findAll();
    }

    public Alert resolveAlert(String id) {
        Alert alert = alertRepo.findById(id).orElseThrow();
        alert.setResolved(true);
        return alertRepo.save(alert);
    }
}
