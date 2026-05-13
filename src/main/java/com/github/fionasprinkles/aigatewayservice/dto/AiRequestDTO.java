package com.github.fionasprinkles.aigatewayservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Result sent to AI provider")
public class AiRequestDTO {

  @Schema(description = "AI model name")
  private String model;

  @Schema(description = "Conversation messages")
  private List<MessageDTO> messages;
}
