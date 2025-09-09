package com.smartsafety.controllers;

import com.smartsafety.models.User;
import com.smartsafety.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    public List<User> listUsers() {
        return userService.listAll();
    }
}
