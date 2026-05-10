package com.github.fionasprinkles.aigatewayservice.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AiRequestDTO {

  private String model;
  private List<MessageDTO> messages;
}
