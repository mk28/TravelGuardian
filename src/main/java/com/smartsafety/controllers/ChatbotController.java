package com.smartsafety.controllers;

import com.smartsafety.services.ChatbotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {
    private final ChatbotService chatbot;

    public ChatbotController(ChatbotService chatbot) { this.chatbot = chatbot; }

    @PostMapping("/ask")
    public ResponseEntity<?> ask(@RequestBody Map<String,String> payload) {
        String message = payload.getOrDefault("message", "");
        String reply = chatbot.respond(message);
        return ResponseEntity.ok(Map.of("reply", reply));
    }
}
