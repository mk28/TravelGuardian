package com.smartsafety.controllers;

import com.smartsafety.models.Alert;
import com.smartsafety.services.AlertService;
import com.smartsafety.services.BlockchainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;
    private final BlockchainService blockchainService;

    public AlertController(AlertService alertService, BlockchainService blockchainService) {
        this.alertService = alertService;
        this.blockchainService = blockchainService;
    }

    @GetMapping
    public List<Alert> all() { return alertService.getAll(); }

    @GetMapping("/user/{userId}")
    public List<Alert> byUser(@PathVariable String userId) {
        return alertService.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Alert> create(@RequestBody Alert a) {
        Alert saved = alertService.createAlert(a);
        // optional: record to blockchain
        blockchainService.recordEvent("alert:" + saved.getId());
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Optional<Alert> a = alertService.findById(id);
        return a.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<?> resolve(@PathVariable String id) {
        Optional<Alert> a = alertService.findById(id);
        if (a.isPresent()) {
            Alert alert = a.get();
            alert.setResolved(true);
            alertService.update(alert);
            return ResponseEntity.ok(alert);
        }
        return ResponseEntity.notFound().build();
    }
}
