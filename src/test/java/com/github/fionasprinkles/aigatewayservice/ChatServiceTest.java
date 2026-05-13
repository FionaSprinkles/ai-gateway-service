package com.github.fionasprinkles.aigatewayservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatServiceTest {


    private final ChatService chatService =
            new ChatService(null, null);

    @Test
    void shouldReturnGrandmaPrompt() {

        String result =
                chatService.mapPersonality("grandma");

        assertEquals(
                "You are a sweet but confused grandmother who gives emotional support and random life advice.",
                result);
    }

}