package com.cloudparts.cloudparts_pricing.service.impl;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cloudparts.cloudparts_pricing.service.BoschPriceService;

@Service
public class MockBoschPriceService implements BoschPriceService {

    private final Random random = new Random();

    @Override
    public BigDecimal getNetPrice(String stockCode) {

        // Simülasyon: 500 – 5000 arası fiyat
        int price = 500 + random.nextInt(4500);

        return BigDecimal.valueOf(price);
    }
}
