package com.ek.flight_info_app.controller;

import com.ek.flight_info_app.service.CacheService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    CacheService cacheService;

    @PutMapping("/clear/{key}")
    public void clearCache(@PathVariable String key) throws InterruptedException {
        cacheService.clearCache(key);
    }
}
