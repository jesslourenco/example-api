package com.example.api.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FooResponse {

    private Long id;
    private String env;

    private Integer quantity;

    private LocalDateTime created;
}
