package com.ek.flight_info_app.service;

import com.ek.flight_info_app.client.MockClient;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class FlightService {

    MockClient downstreamClient;

    public FlightService(MockClient downstreamClient) {
        this.downstreamClient = downstreamClient;
    }

    @Cacheable(value = "flightNumber", keyGenerator = "flightCacheKeyGenerator")
    public Mono<String> getFlightNumber(String date, String departure, String arrival) {

        return downstreamClient.downstream1()
                .then(downstreamClient.downstream2())
                .then(downstreamClient.downstream3())
                .then(downstreamClient.downstream4())
                .then(downstreamClient.downstream5(date, departure, arrival));
    }

    public Mono<String> getPrice(String date, String flightNumber) {

        return Mono.just("EK450");
    }
}
