package com.github.fionasprinkles.aigatewayservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

/** Represents OpenRouters response */
@Data
@Schema(description = "Response recieved from AI provider")
public class AiResponseDTO {

  @Schema(description = "List of AI response choices")
  private List<ChoiceDTO> choices;
}
