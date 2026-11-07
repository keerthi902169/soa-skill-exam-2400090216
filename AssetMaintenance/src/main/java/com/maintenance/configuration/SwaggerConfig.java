package com.maintenance.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Asset Maintenance API")
                        .version("1.0")
                        .description("CRUD Operations for Asset Maintenance")
                        .contact(new Contact()
                                .name("Keerthi")
                                .email("keerthi@example.com")));
    }
}