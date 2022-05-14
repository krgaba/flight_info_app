package com.ek.flight_info_app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    @CacheEvict(value = "flightNumber", keyGenerator = "flightCacheKeyGenerator")
    public void clearCache(String key) {
        LOGGER.info("Cache cleared for following key: {}", key);
    }

}
