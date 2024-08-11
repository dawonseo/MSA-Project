package com.sparta.msa_exam.gateway.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomPostFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            ServerHttpResponse response = exchange.getResponse();
            int port = exchange.getRequest().getURI().getPort();
            response.getHeaders().add("Server-Port", String.valueOf(port));
        }));
    }

    @Override
    public int getOrder() {
        // 필터 순서를 가장 낮은 순위로 설정
        return Ordered.LOWEST_PRECEDENCE;
    }
}