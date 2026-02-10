package com.cloudparts.cloudparts_pricing.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudparts.cloudparts_pricing.model.ProductRow;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceUpdateService {

    private final PriceCalculationService priceCalculationService;

    public void updatePrices(List<ProductRow> products) {

        for (ProductRow product : products) {

            // Bosch’tan gelen net fiyat (şimdilik MOCK)
            BigDecimal boschNetPrice = product.getPrice();

            BigDecimal finalPrice = priceCalculationService.calculate(boschNetPrice);

            product.setPrice(finalPrice);
            product.setDiscountPrice(finalPrice);
        }
    }
}
