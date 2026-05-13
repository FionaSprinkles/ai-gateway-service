package com.github.fionasprinkles.aigatewayservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request from client to AI gateway")
public class ChatRequestDTO {

  @NotBlank(message = "Personality is required")
  @Schema(description = "AI personality to use")
  private String personality;

  @NotBlank(message = "Message is required")
  @Schema(description = "User message")
  private String message;

  @NotBlank(message = "Session id is required")
  @Schema(description = "Conversation session id")
  private String sessionId;
}
