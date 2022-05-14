package com.ek.flight_info_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mock")
public class MockDataController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MockDataController.class);

    public MockDataController() {
    }

    @GetMapping("/downstream1")
    public Mono<String> downstream1() throws InterruptedException {
        LOGGER.info("Downstream1 is called!");
        Thread.sleep(500);
        LOGGER.info("Downstream1 is returned!");
        return Mono.just("someData");
    }

    @GetMapping("/downstream2")
    public Mono<String> downstream2() throws InterruptedException {
        LOGGER.info("Downstream2 is called!");
        Thread.sleep(600);
        LOGGER.info("Downstream2 is returned!");
        return Mono.just("someData");
    }

    @GetMapping("/downstream3")
    public Mono<String> downstream3() throws InterruptedException {
        LOGGER.info("Downstream3 is called!");
        Thread.sleep(700);
        LOGGER.info("Downstream3 is returned!");
        return Mono.just("someData");
    }

    @GetMapping("/downstream4")
    public Mono<String> downstream4() throws InterruptedException {
        LOGGER.info("Downstream4 is called!");
        Thread.sleep(800);
        LOGGER.info("Downstream4 is returned!");
        return Mono.just("someData");
    }

    @GetMapping("/downstream5")
    public Mono<String> downstream5(@RequestParam String date, @RequestParam String dep, @RequestParam String arr)
            throws InterruptedException {
        LOGGER.info("Downstream5 is called!");
        Thread.sleep(500);
        var flightNumber = String.format("%s%s%s", dep.charAt(0), arr.charAt(0), date.substring(0, 4).replace("-", ""));
        LOGGER.info("Downstream5 is returned!");
        return Mono.just(flightNumber);
    }
}
