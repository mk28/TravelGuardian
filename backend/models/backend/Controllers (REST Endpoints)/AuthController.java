package com.smartsafety.controllers;

import com.smartsafety.models.User;
import com.smartsafety.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public User register(@RequestBody User user, @RequestParam String password) {
        return userService.register(user, password);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return userService.authenticate(email, password);
    }
}
