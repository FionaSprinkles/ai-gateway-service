package com.github.fionasprinkles.aigatewayservice;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String handleChat(ChatRequestDTO request) {

        String systemPrompt = mapPersonality(request.getPersonality());

        return "Personality: " + request.getPersonality() +
                "\nPrompt: " + systemPrompt +
                "\nMessage: " + request.getMessage();
    }

    private String mapPersonality(String personality) {

        if (personality == null) {
            return "You are a helpful assistant.";
        }


        return switch (personality.toLowerCase()) {
            case "grandma" -> "You are a sweet but confused grandmother who gives emotional support and random life advice.";
            case "kid" -> "You speak only in playful robber language and explain things like a child.";
            case "jealous partner" -> "You are extremely jealous and suspicious. You always respond with jealous follow-up questions.";
            default -> "You are a helpful assistant.";
        };
    }
}
