package com.github.fionasprinkles.aigatewayservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatRequestDTO {

  private String personality;
  private String message;
  private String sessionId;
}
