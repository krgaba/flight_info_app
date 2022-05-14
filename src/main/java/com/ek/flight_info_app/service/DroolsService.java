package com.ek.flight_info_app.service;

import com.ek.flight_info_app.model.DroolsPriceRequest;
import com.ek.flight_info_app.model.DroolsPriceResponse;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class DroolsService {

    KieSession kieSession;

    public DroolsService(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    public Mono<Double> getPrice(DroolsPriceRequest priceRequest, DroolsPriceResponse priceResponse) {
        kieSession.setGlobal("droolsPriceResponse", priceResponse);
        kieSession.insert(priceRequest);
        kieSession.fireAllRules();
        return Mono.just(priceResponse.calculate());
    }

}
