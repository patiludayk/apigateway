package com.uday.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("id1", r -> r.host("**.localhost:8080")
                        .and()
                        .path("/service")
                        .uri("http://localhost:8081"))  //service host URI
                .route("id2", r -> r.host("**.localhost:8080")
                        .and()
                        .path("/service1")
                        //.filters(f -> f.prefixPath("/myPrefix"))
                        .uri("http://localhost:8082"))  //service host URI
                //.id("id2"))
                .build();
    }

    @Bean
    public RouteLocator anotherCustomRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("id1", r -> r.host("**.localhost:8080")
                        .and()
                        .path("/service2")
                        .uri("http://localhost:8083"))  //service host URI
                .build();
    }
}
