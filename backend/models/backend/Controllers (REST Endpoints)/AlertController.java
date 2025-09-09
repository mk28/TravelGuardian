package com.smartsafety.controllers;

import com.smartsafety.models.Alert;
import com.smartsafety.services.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) { this.alertService = alertService; }

    @PostMapping
    public Alert create(@RequestBody Alert alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping
    public List<Alert> list() {
        return alertService.getAll();
    }

    @PostMapping("/{id}/resolve")
    public Alert resolve(@PathVariable String id) {
        return alertService.resolveAlert(id);
    }
}
