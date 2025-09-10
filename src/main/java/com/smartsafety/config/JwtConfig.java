package com.smartsafety.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret:change-me}")
    private String jwtSecret;

    @Value("${jwt.expiration-ms:86400000}")
    private long expirationMs;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public long getExpirationMs() {
        return expirationMs;
    }
}
