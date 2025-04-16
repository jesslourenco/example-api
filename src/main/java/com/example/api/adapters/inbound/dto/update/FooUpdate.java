package com.example.api.dto.update;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FooUpdate {

    @NotNull
    private String env;

    @NotNull
    private Integer quantity;

}
