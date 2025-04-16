package com.example.api.adapters.inbound.dto.request;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public abstract class GenericRequest {

    @Min(0)
    private Integer page = 0;

    @Max(50)
    private Integer limit = 50;

    private String[] sort;

    public PageRequest pageable() {
        return PageRequest.of(page, limit);
    }
}

