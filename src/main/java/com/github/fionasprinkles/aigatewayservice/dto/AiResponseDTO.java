package com.github.fionasprinkles.aigatewayservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class AiResponseDTO {

    private List<ChoiceDTO> choices;
}
