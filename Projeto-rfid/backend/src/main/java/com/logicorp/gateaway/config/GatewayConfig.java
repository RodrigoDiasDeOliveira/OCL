package com.logicorp.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()

            .route("rfid-service", r -> r.path("/api/rfid/**")
                .uri("http://localhost:8081"))

            .route("prediction-service", r -> r.path("/api/predict/**")
                .uri("http://localhost:8082"))

            .route("integration-service", r -> r.path("/api/integration/**")
                .uri("http://localhost:8083"))

            .build();
    }
}