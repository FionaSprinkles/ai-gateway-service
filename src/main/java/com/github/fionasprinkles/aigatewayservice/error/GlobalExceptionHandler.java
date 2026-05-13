package com.github.fionasprinkles.aigatewayservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class GlobalExceptionHandler {

  /** Handle 400 validation errors */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDTO> handleValidationException(
      MethodArgumentNotValidException e) {

    ErrorResponseDTO error = new ErrorResponseDTO("Invalid request data");

    return ResponseEntity.badRequest().body(error);
  }

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

  /** 500 Fallback exception handler */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {

    ErrorResponseDTO error = new ErrorResponseDTO("Something went wrong");

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

  /** Handle 503 service unavailable */
  @ExceptionHandler(WebClientResponseException.ServiceUnavailable.class)
  public ResponseEntity<ErrorResponseDTO> handleServiceUnavailable() {

    ErrorResponseDTO error = new ErrorResponseDTO("AI service is currently unavailable");

    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
  }
}
