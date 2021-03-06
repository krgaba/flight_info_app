package com.ek.flight_info_app.controller;

import com.ek.flight_info_app.model.FlightNumberResponse;
import com.ek.flight_info_app.model.PriceResponse;
import com.ek.flight_info_app.service.FlightService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flight")
    public Mono<FlightNumberResponse> getFlightNumber(@RequestParam String date, @RequestParam String departure,
            @RequestParam String arrival) {
        return flightService.getFlightNumber(date, departure, arrival)
                .flatMap(flightNumber -> Mono.just(new FlightNumberResponse(flightNumber)));
    }

    @GetMapping("/price")
    public Mono<PriceResponse> getPrice(@RequestParam String flightNumber, @RequestParam String date) {
        return flightService.getPrice(date, flightNumber);
    }
}
