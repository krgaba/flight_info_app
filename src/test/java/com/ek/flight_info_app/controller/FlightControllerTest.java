package com.ek.flight_info_app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ek.flight_info_app.model.PriceResponse;
import com.ek.flight_info_app.service.FlightService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
public class FlightControllerTest {

    @InjectMocks
    FlightController flightController;

    @Mock
    FlightService flightService;

    @Test
    void testGetFlightNumber() {
        when(flightService.getFlightNumber(any(), any(), any())).thenReturn(Mono.just("EK415"));
        assertEquals("EK415", flightController.getFlightNumber("01-01-2021", "ORD", "DXB").block().getFlightNumber());
    }

    @Test
    void testGetPrice() {
        when(flightService.getPrice(any(), any())).thenReturn(Mono.just(new PriceResponse(1150.00)));
        assertEquals(1150.00, flightController.getPrice("EK501", "01-02-2022").block().getPrice());
    }
}
