package com.github.fionasprinkles.aigatewayservice.dto;

import java.util.List;
import lombok.Data;

/** Represents OpenRouters response */
@Data
public class AiResponseDTO {

  private List<ChoiceDTO> choices;
}
