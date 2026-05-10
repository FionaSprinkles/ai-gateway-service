package com.github.fionasprinkles.aigatewayservice.dto;

import lombok.Data;

import java.util.List;

/**
 *
 *Represents OpenRouters response
 */

@Data
public class AiResponseDTO {

    private List<ChoiceDTO> choices;
}
