package com.smartsafety.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "alerts")
public class Alert {
    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private Location location;
    private Instant createdAt;
    private boolean resolved;

    public Alert() {}

    public Alert(String title, String description, String userId, Location location, Instant createdAt, boolean resolved) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.location = location;
        this.createdAt = createdAt;
        this.resolved = resolved;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
