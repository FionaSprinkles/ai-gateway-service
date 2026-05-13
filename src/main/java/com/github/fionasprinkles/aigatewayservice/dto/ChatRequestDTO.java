package com.github.fionasprinkles.aigatewayservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request from client to AI gateway")
public class ChatRequestDTO {

  @Schema(description = "AI personality to use")
  private String personality;

  @Schema(description = "User message")
  private String message;

  @Schema(description = "Conversation session id")
  private String sessionId;
}
