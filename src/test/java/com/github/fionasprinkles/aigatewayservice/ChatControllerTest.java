package com.github.fionasprinkles.aigatewayservice;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fionasprinkles.aigatewayservice.dto.ChatRequestDTO;
import com.github.fionasprinkles.aigatewayservice.dto.ChatResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ChatController.class)
class ChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private ChatService chatService;

    @Test
    void shouldReturnChatResponse() throws Exception {

        ChatRequestDTO request =
                new ChatRequestDTO(
                        "helper",
                        "Hello",
                        "session-123"
                );

        ChatResponseDTO response =
                new ChatResponseDTO("Hi there!");

        when(chatService.handleChat(request))
                .thenReturn(response);

        mockMvc.perform(
                        post("/chat")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response")
                        .value("Hi there!"));
    }

}