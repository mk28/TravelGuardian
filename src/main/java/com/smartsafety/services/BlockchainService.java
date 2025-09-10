package com.smartsafety.services;

import org.springframework.stereotype.Service;

/**
 * Stub Blockchain service - implement properly if you plan to anchor alerts/user records.
 */
@Service
public class BlockchainService {
    public String recordEvent(String payload) {
        // In a real system you'd send to a ledger, sign, return tx id
        return "tx_stub_" + System.currentTimeMillis();
    }
}

