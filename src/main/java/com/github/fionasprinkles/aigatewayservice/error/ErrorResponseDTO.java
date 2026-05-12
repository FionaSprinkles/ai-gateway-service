package com.github.fionasprinkles.aigatewayservice.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Error response returned from API")
public class ErrorResponseDTO {

  @Schema(description = "Description of the error")
  private String errorMessage;
}
