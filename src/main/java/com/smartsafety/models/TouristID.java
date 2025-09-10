package com.smartsafety.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "touristids")
public class TouristID {
    @Id
    private String id;
    private String passportNumber;
    private String country;
    private Instant issuedAt;
    private Instant expiresAt;
    private String userId;

    public TouristID() {}

    public TouristID(String passportNumber, String country, Instant issuedAt, Instant expiresAt, String userId) {
        this.passportNumber = passportNumber;
        this.country = country;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
        this.userId = userId;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Instant getIssuedAt() { return issuedAt; }
    public void setIssuedAt(Instant issuedAt) { this.issuedAt = issuedAt; }

    public Instant getExpiresAt() { return expiresAt; }
    public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
