package com.github.fionasprinkles.aigatewayservice;

import com.github.fionasprinkles.aigatewayservice.dto.MessageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SessionMemoryServiceTest {

    private SessionMemoryService sessionMemoryService;


    @BeforeEach
    void setUp() {
        sessionMemoryService = new SessionMemoryService();
    }

    /**
     * Verifies that a new session returns an empty message list.
     */
    @Test
    void shouldReturnEmptyListForNewSession() {


        List<MessageDTO> messages =
                sessionMemoryService.getMessages("session-123");

        assertTrue(messages.isEmpty());
    }

    /**
     * Verifies that a message can be added to a session.
     */
    @Test
    void shouldAddMessageToSession() {

        MessageDTO message =
                new MessageDTO("user", "Hello");

        sessionMemoryService.addMessage("session-123", message);

        List<MessageDTO> messages =
                sessionMemoryService.getMessages("session-123");

        assertEquals(1, messages.size());
        assertEquals("Hello", messages.getFirst().getContent());
    }
}