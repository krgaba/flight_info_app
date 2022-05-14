package com.ek.flight_info_app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ek.flight_info_app.model.DroolsPriceRequest;
import com.ek.flight_info_app.model.DroolsPriceResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class DroolsServiceTest {

    @InjectMocks
    DroolsService droolsService;

    @Mock
    KieSession kieSession;

    @Test
    void testGetPrice() {
        var droolsPriceRequest = new DroolsPriceRequest();
        droolsPriceRequest.setDay(1);
        droolsPriceRequest.setDayOfWeek(5);
        droolsPriceRequest.setFlighNumber("EK451");
        droolsPriceRequest.setMonth(12);

        DroolsPriceResponse response = mock(DroolsPriceResponse.class);
        FactHandle factHandle = mock(FactHandle.class);

        when(response.calculate()).thenReturn(2100.00);
        doNothing().when(kieSession).setGlobal(any(), any());
        when(kieSession.insert(any())).thenReturn(factHandle);
        when(kieSession.fireAllRules()).thenReturn(1);

        assertEquals(2100, droolsService.getPrice(droolsPriceRequest, response).block());
    }
}
