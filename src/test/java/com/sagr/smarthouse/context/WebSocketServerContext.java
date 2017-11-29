package com.sagr.smarthouse.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Mono;

@Configuration
public class WebSocketServerContext {
    @Bean
    public HandlerMapping webSocketMapping(WebSocketHandler echoWebSocketHandler) {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/echo", echoWebSocketHandler);

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(map);
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

    @Bean
    public WebSocketHandler echoWebSocketHandler() {
        return new WebSocketHandler() {
            @Override
            public Mono<Void> handle(WebSocketSession webSocketSession) {
                return null;
            }
        };
    }
}
