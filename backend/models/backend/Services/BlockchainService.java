package com.smartsafety.services;

import org.springframework.stereotype.Service;

@Service
public class BlockchainService {
    public String verifyTouristID(String touristId) {
        // TODO: Connect to Ethereum smart contract
        return "Verification for " + touristId + " is stubbed.";
    }
}
