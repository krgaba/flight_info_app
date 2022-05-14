package com.ek.flight_info_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FlightController {

    @GetMapping("/flight")
    public Mono<String> getFlightNumber(@RequestParam String date, @RequestParam String departure,
            @RequestParam String arrival) {
        return Mono.just("EK123");
    }

    @GetMapping("/price")
    public Mono<String> getPrice(@RequestParam String flightNumber, @RequestParam String date) {
        return Mono.just("$1400.00");
    }
}
