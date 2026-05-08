package com.github.fionasprinkles.aigatewayservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AiRequestDTO {

    private String model;
    private List<MessageDTO> messages;
}
