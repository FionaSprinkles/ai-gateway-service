package com.github.fionasprinkles.aigatewayservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents my API response */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response returned from AI gateway")
public class ChatResponseDTO {

  @Schema(description = "AI generated response")
  private String response;
}
