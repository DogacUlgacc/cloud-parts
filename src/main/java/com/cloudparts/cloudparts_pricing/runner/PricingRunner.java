package com.cloudparts.cloudparts_pricing.runner;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cloudparts.cloudparts_pricing.model.ProductRow;
import com.cloudparts.cloudparts_pricing.service.BoschPriceService;
import com.cloudparts.cloudparts_pricing.service.ExcelReaderService;
import com.cloudparts.cloudparts_pricing.service.ExcelWriterService;
import com.cloudparts.cloudparts_pricing.service.PriceCalculationService;

@Component
public class PricingRunner implements CommandLineRunner {

    private final ExcelReaderService excelReaderService;
    private final BoschPriceService boschPriceService;
    private final PriceCalculationService priceCalculationService;
    private final ExcelWriterService excelWriterService;

    public PricingRunner(
            ExcelReaderService excelReaderService,
            BoschPriceService boschPriceService,
            PriceCalculationService priceCalculationService,
            ExcelWriterService excelWriterService) {
        this.excelReaderService = excelReaderService;
        this.boschPriceService = boschPriceService;
        this.priceCalculationService = priceCalculationService;
        this.excelWriterService = excelWriterService;
    }

    @Override
    public void run(String... args) {

        String inputPath = "C:/Users/dogac/Desktop/cloudParts/Ürünleriniz_10.02.26-13.14.xlsx";

        String outputPath = "C:/Users/dogac/Desktop/cloudParts/output.xlsx";

        List<ProductRow> products = excelReaderService.read(inputPath);

        for (ProductRow p : products) {

            BigDecimal boschNet = boschPriceService.getNetPrice(p.getStockCode());

            BigDecimal newPrice = priceCalculationService.calculate(boschNet);

            p.setPrice(newPrice);
            p.setDiscountPrice(newPrice);
        }

        excelWriterService.writeProductExcel(products, outputPath);

        System.out.println("Excel başarıyla oluşturuldu: " + outputPath);
    }

}
