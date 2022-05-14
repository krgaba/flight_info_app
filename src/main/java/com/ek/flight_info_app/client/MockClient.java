package com.ek.flight_info_app.client;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MockClient {

    WebClient client = WebClient.create("http://localhost:8080");

    public Mono<String> downstream1() {
        return Mono.fromFuture(asyncClient("/mock/downstream1"));
    }

    public Mono<String> downstream2() {
        return Mono.fromFuture(asyncClient("/mock/downstream2"));
    }

    public Mono<String> downstream3() {
        return Mono.fromFuture(asyncClient("/mock/downstream3"));
    }

    public Mono<String> downstream4() {
        return Mono.fromFuture(asyncClient("/mock/downstream4"));
    }

    public Mono<String> downstream5(String date, String dep, String arr) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return client.get()
                    .uri(builder -> builder.path("/mock/downstream5")
                            .queryParam("date", date)
                            .queryParam("dep", dep)
                            .queryParam("arr", arr)
                            .build())
                    .retrieve()
                    .bodyToMono(String.class).block();
        });
        return Mono.fromFuture(future);
    }

    private CompletableFuture<String> asyncClient(String endpoint) {
        return CompletableFuture.supplyAsync(() -> {
            return client.get().uri(endpoint).retrieve().bodyToMono(String.class).block();
        });
    }
}
