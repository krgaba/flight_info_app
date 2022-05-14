package com.ek.flight_info_app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ek.flight_info_app.client.MockClient;
import com.ek.flight_info_app.model.DroolsPriceRequest;
import com.ek.flight_info_app.model.DroolsPriceResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
public class FlightServiceTest {

    @InjectMocks
    FlightService flightService;

    @Mock
    MockClient mockClient;

    @Mock
    DroolsService droolsService;

    @Test
    void testGetFlightNumber() {
        when(mockClient.downstream1()).thenReturn(Mono.just("someData"));
        when(mockClient.downstream2()).thenReturn(Mono.just("someData"));
        when(mockClient.downstream3()).thenReturn(Mono.just("someData"));
        when(mockClient.downstream4()).thenReturn(Mono.just("someData"));
        when(mockClient.downstream5(any(), any(), any())).thenReturn(Mono.just("EK511"));

        assertEquals("EK511", flightService.getFlightNumber("2021-12-11", "ORD",
                "DXB").block());

    }

    @Test
    void testGetPrice() {
        when(droolsService.getPrice(any(DroolsPriceRequest.class), any(DroolsPriceResponse.class))).thenReturn(Mono.just(1200.00));

        assertEquals(1200.00, flightService.getPrice("12-12-2021", "EK511").block().getPrice());
    }
}
