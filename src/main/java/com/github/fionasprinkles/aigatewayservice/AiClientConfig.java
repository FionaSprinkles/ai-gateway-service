package com.github.fionasprinkles.aigatewayservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AiClientConfig {

  @Value("${openrouter.api.key}")
  private String apiKey;

  @Bean
  public WebClient webClient() {
    return WebClient.builder()
        .baseUrl("https://openrouter.ai/api/v1")
        .defaultHeader("Authorization", "Bearer " + apiKey)
        .defaultHeader("Content-Type", "application/json")
        .build();
  }
}
