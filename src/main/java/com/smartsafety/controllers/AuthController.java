package com.smartsafety.controllers;

import com.smartsafety.models.User;
import com.smartsafety.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        // Very simple: check existing email
        Optional<User> existing = userService.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email already used"));
        }
        User saved = userService.createUser(user);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        String email = body.get("email");
        if (email == null) return ResponseEntity.badRequest().body(Map.of("error","email required"));
        Optional<User> u = userService.findByEmail(email);
        if (u.isPresent()) {
            // No password in this simple example; production must check hashed password & return JWT
            return ResponseEntity.ok(Map.of("message","login ok", "user", u.get()));
        }
        return ResponseEntity.status(401).body(Map.of("error","invalid credentials"));
    }
}
