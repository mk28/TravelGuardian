package com.smartsafety.services;

import com.smartsafety.models.Alert;
import com.smartsafety.repositories.AlertRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {
    private final AlertRepository alerts;

    public AlertService(AlertRepository alerts) {
        this.alerts = alerts;
    }

    public Alert createAlert(Alert a) {
        if (a.getCreatedAt() == null) a.setCreatedAt(Instant.now());
        return alerts.save(a);
    }

    public Optional<Alert> findById(String id) { return alerts.findById(id); }

    public List<Alert> findByUserId(String userId) { return alerts.findByUserId(userId); }

    public List<Alert> getAll() { return alerts.findAll(); }

    public Alert update(Alert a) { return alerts.save(a); }

    public void delete(String id) { alerts.deleteById(id); }
}
