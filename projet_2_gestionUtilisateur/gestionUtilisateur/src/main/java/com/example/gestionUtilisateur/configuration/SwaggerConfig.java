package com.example.gestionUtilisateur.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SwaggerConfig {
    @Bean
    @Primary
    public SwaggerUiConfigProperties swaggerUiConfig() {
        SwaggerUiConfigProperties properties = new SwaggerUiConfigProperties();
        properties.setConfigUrl("/v3/api-docs/swagger-config"); // Points to your local config
        properties.setValidatorUrl(null); // Disables the external validator
        return properties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("API avec JWT")
                        .version("1.0"))
                // Supprime les schémas par défaut et ajoute JWT
                .components(new Components()
                        .addSecuritySchemes("BearerAuth", new SecurityScheme()
                                .name("Authorization")  // Nom du header attendu
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"));
    }


}