package com.github.fionasprinkles.aigatewayservice.dto;

import lombok.Data;

@Data
public class ChatRequestDTO {

  private String personality;
  private String message;
  private String sessionId;
}
