package com.cloudparts.cloudparts_pricing.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class PriceCalculationService {

    private static final BigDecimal KDV = new BigDecimal("0.20");
    private static final BigDecimal PROFIT = new BigDecimal("0.15");

    public BigDecimal calculate(BigDecimal netBoschPrice) {

        BigDecimal withKdv = netBoschPrice.multiply(BigDecimal.ONE.add(KDV));
        BigDecimal withProfit = withKdv.multiply(BigDecimal.ONE.add(PROFIT));

        return withProfit.setScale(2, RoundingMode.HALF_UP);
    }
}
