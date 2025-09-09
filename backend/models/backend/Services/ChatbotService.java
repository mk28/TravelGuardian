package com.smartsafety.services;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
    public String ask(String question) {
        // Stub: connect to GPT/LLM later
        return "You asked: " + question + ". (Stubbed response)";
    }
}
