package com.smartsafety.services;

import com.smartsafety.models.User;
import com.smartsafety.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public User createUser(User u) {
        return users.save(u);
    }

    public Optional<User> findById(String id) { return users.findById(id); }

    public Optional<User> findByEmail(String email) { return users.findByEmail(email); }

    public List<User> getAll() { return users.findAll(); }

    public void deleteById(String id) { users.deleteById(id); }
}
