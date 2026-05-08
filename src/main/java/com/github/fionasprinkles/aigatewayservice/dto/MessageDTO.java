package com.github.fionasprinkles.aigatewayservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDTO {

    private String role;
    private String content;
}
