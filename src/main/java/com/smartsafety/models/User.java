package com.smartsafety.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private List<String> roles;
    private String touristIdRef; // link to TouristID if any

    public User() {}

    public User(String name, String email, String phone, List<String> roles, String touristIdRef) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
        this.touristIdRef = touristIdRef;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }

    public String getTouristIdRef() { return touristIdRef; }
    public void setTouristIdRef(String touristIdRef) { this.touristIdRef = touristIdRef; }
}
