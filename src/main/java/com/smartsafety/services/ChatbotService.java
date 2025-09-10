package com.smartsafety.services;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    // Minimal example stub. Connect to an NLP model or rule engine as needed.
    public String respond(String message) {
        if (message == null) return "Hello! How can I help?";
        String msg = message.toLowerCase();
        if (msg.contains("help") || msg.contains("sos")) {
            return "If this is an emergency, contact local authorities. Otherwise describe your issue.";
        }
        if (msg.contains("status")) return "All systems operational.";
        return "Thanks — I received: \"" + message + "\". A human will review it if needed.";
    }
}
