package com.logicorp.gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;

@Component
public class JwtGatewayFilter implements GatewayFilter {

    @Override
    public reactor.core.publisher.Mono<Void> filter(ServerWebExchange exchange,
                                                    GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        String auth = request.getHeaders().getFirst("Authorization");

        if (auth == null || !auth.startsWith("Bearer ")) {
            throw new RuntimeException("Missing JWT");
        }

        return chain.filter(exchange);
    }
}