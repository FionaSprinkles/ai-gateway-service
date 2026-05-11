package com.github.fionasprinkles.aigatewayservice.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {

  private String errorMessage;
}
