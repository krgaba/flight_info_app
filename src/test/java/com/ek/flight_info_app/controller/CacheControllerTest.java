package com.ek.flight_info_app.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import com.ek.flight_info_app.service.CacheService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CacheControllerTest {

    @InjectMocks
    CacheController cacheController;

    @Mock
    CacheService cacheService;

    @Test
    void testClearCache() {
        doNothing().when(cacheService).clearCache(eq("testkey"));
        cacheController.clearCache("testkey");
    }
}
