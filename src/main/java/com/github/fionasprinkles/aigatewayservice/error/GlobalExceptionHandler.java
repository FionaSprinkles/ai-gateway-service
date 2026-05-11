package com.github.fionasprinkles.aigatewayservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class GlobalExceptionHandler {

  /** Handle 401 unauthorized */
  @ExceptionHandler(WebClientResponseException.Unauthorized.class)
  public ResponseEntity<ErrorResponseDTO> handleUnauthorized() {

    ErrorResponseDTO error = new ErrorResponseDTO("Invalid API credentials");

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
  }

  /** Handle 429 too many requests */
  @ExceptionHandler(WebClientResponseException.TooManyRequests.class)
  public ResponseEntity<ErrorResponseDTO> handleTooManyRequests() {

    ErrorResponseDTO error = new ErrorResponseDTO("AI service is busy, please try again later");

    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(error);
  }

  /** Fallback exception handler */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {

    ErrorResponseDTO error = new ErrorResponseDTO("Something went wrong");

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
