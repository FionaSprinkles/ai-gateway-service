package com.github.fionasprinkles.aigatewayservice;

import com.github.fionasprinkles.aigatewayservice.dto.ChatRequestDTO;
import com.github.fionasprinkles.aigatewayservice.dto.ChatResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Chat API", description = "Endpoints for chat")
@RequiredArgsConstructor
@RestController
public class ChatController {

  private final ChatService chatService;

  @Operation(summary = "Send message to AI")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Successful response"),
        @ApiResponse(responseCode = "401", description = "Invalid API credentials"),
        @ApiResponse(responseCode = "429", description = "Too many requests"),
        @ApiResponse(responseCode = "503", description = "AI service unavailable")
      })
  @PostMapping("/chat")
  public ChatResponseDTO chat(@RequestBody ChatRequestDTO request) {
    return chatService.handleChat(request);
  }
}
