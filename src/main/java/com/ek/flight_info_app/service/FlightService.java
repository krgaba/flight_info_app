package com.ek.flight_info_app.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.ek.flight_info_app.client.MockClient;
import com.ek.flight_info_app.model.DroolsPriceRequest;
import com.ek.flight_info_app.model.PriceResponse;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class FlightService {

    MockClient downstreamClient;

    DroolsService droolsService;

    public FlightService(MockClient downstreamClient, DroolsService droolsService) {
        this.downstreamClient = downstreamClient;
        this.droolsService = droolsService;
    }

    @Cacheable(value = "flightNumber", keyGenerator = "flightCacheKeyGenerator")
    public Mono<String> getFlightNumber(String date, String departure, String arrival) {

        return downstreamClient.downstream1()
                .then(downstreamClient.downstream2())
                .then(downstreamClient.downstream3())
                .then(downstreamClient.downstream4())
                .then(downstreamClient.downstream5(date, departure, arrival));
    }

    public Mono<PriceResponse> getPrice(String date, String flightNumber) {

        return Mono.just(flightNumber)
                .zipWith(Mono.just(date))
                .flatMap(tuple -> {
                    var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US);
                    var dateTime = LocalDate.parse(tuple.getT2(), formatter).atStartOfDay();
                    var priceRequest = new DroolsPriceRequest();
                    priceRequest.setDayOfWeek(dateTime.getDayOfWeek().getValue());
                    priceRequest.setDay(dateTime.getDayOfMonth());
                    priceRequest.setMonth(dateTime.getMonthValue());
                    priceRequest.setFlighNumber(tuple.getT1());
                    return Mono.just(priceRequest);
                })
                .flatMap(droolsService::getPrice)
                .flatMap(price -> Mono.just(new PriceResponse(price)));
    }
}
