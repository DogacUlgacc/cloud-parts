package com.cloudparts.cloudparts_pricing.service;

import java.math.BigDecimal;

public interface BoschPriceService {
    BigDecimal getNetPrice(String stockCode);
}
