package com.github.fionasprinkles.aigatewayservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Single chat message")
public class MessageDTO {

  @Schema(description = "Role of the message sender")
  private String role;

  @Schema(description = "Message content")
  private String content;
}
