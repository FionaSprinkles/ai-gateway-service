package com.github.fionasprinkles.aigatewayservice.error;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fionasprinkles.aigatewayservice.ChatController;
import com.github.fionasprinkles.aigatewayservice.ChatService;
import com.github.fionasprinkles.aigatewayservice.dto.ChatRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@WebMvcTest(ChatController.class)
class GlobalExceptionHandlerTest {

  @Autowired private MockMvc mockMvc;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @MockitoBean private ChatService chatService;

  /** Verifies that the API returns HTTP 429 when the AI provider rate limits requests. */
  @Test
  void shouldReturn429WhenTooManyRequests() throws Exception {

    ChatRequestDTO request = new ChatRequestDTO("helper", "Hello", "session-123");

    when(chatService.handleChat(any()))
        .thenThrow(WebClientResponseException.create(429, "Too many requests", null, null, null));

    mockMvc
        .perform(
            post("/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isTooManyRequests())
        .andExpect(jsonPath("$.errorMessage").value("AI service is busy, please try again later"));
  }

  /** Verifies that the API returns HTTP 401 when API credentials are invalid. */
  @Test
  void shouldReturn401WhenUnauthorized() throws Exception {

    ChatRequestDTO request = new ChatRequestDTO("helper", "Hello", "session-123");

    when(chatService.handleChat(any()))
        .thenThrow(WebClientResponseException.create(401, "Unauthorized", null, null, null));

    mockMvc
        .perform(
            post("/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isUnauthorized())
        .andExpect(jsonPath("$.errorMessage").value("Invalid API credentials"));
  }

    /**
     * Verifies that the API returns HTTP 503
     * when the AI service is unavailable.
     */
    @Test
    void shouldReturn503WhenServiceUnavailable() throws Exception {

        ChatRequestDTO request =
                new ChatRequestDTO("helper", "Hello", "session-123");

        when(chatService.handleChat(any()))
                .thenThrow(
                        WebClientResponseException.create(
                                503,
                                "Service unavailable",
                                null,
                                null,
                                null));

        mockMvc.perform(
                        post("/chat")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isServiceUnavailable())
                .andExpect(jsonPath("$.errorMessage")
                        .value("AI service is currently unavailable"));
    }
}
