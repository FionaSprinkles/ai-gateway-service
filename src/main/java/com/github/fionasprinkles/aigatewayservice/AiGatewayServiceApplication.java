package com.github.fionasprinkles.aigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class AiGatewayServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AiGatewayServiceApplication.class, args);
  }
}
