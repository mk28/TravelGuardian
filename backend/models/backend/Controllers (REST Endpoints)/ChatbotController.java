package com.smartsafety.controllers;

import com.smartsafety.services.ChatbotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {
    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) { this.chatbotService = chatbotService; }

    @PostMapping("/ask")
    public String ask(@RequestParam String question) {
        return chatbotService.ask(question);
    }
}
