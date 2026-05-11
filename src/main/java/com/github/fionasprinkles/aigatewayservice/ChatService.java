package com.github.fionasprinkles.aigatewayservice;

import com.github.fionasprinkles.aigatewayservice.dto.*;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@AllArgsConstructor
@Service
public class ChatService {

  private final WebClient webClient;

  @Retryable(
      retryFor = {
        WebClientResponseException.TooManyRequests.class,
        WebClientResponseException.ServiceUnavailable.class
      },
      maxAttempts = 3,
      backoff = @Backoff(delay = 2000))
  public ChatResponseDTO handleChat(ChatRequestDTO request) {

    String systemPrompt = mapPersonality(request.getPersonality());

    MessageDTO systemMessage = new MessageDTO("system", systemPrompt);

    MessageDTO userMessage = new MessageDTO("user", request.getMessage());

    AiRequestDTO aiRequest =
        new AiRequestDTO("google/gemini-2.5-flash-lite", List.of(systemMessage, userMessage));

    AiResponseDTO response =
        webClient
            .post()
            .uri("/chat/completions")
            .bodyValue(aiRequest)
            .retrieve()
            .bodyToMono(AiResponseDTO.class)
            .block();

    String content = response.getChoices().getFirst().getMessage().getContent();

    return new ChatResponseDTO(content);
  }

  private String mapPersonality(String personality) {

    if (personality == null) {
      return "You are a helpful assistant.";
    }

    return switch (personality.toLowerCase()) {
      case "grandma" ->
          "You are a sweet but confused grandmother who gives emotional support and random life advice.";
      case "kid" -> "You speak only in playful robber language and explain things like a child.";
      case "jealous partner" ->
          "You are extremely jealous and suspicious. You always respond with jealous follow-up questions.";
      default -> "You are a helpful assistant.";
    };
  }
}
