package com.example.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class OpenApiConfiguration {

    private final BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(info());
    }

    private Info info() {
        return new Info()
                .title(buildProperties.getName())
                .description(buildProperties.get("description"))
                .version(buildProperties.getVersion());
    }
}
