package com.github.fionasprinkles.aigatewayservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Single response choice from AI")
public class ChoiceDTO {

  @Schema(description = "Message returned from AI")
  private MessageDTO message;
}
