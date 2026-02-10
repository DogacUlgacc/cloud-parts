package com.cloudparts.cloudparts_pricing.service;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExcelJobRunner {

    // private final ExcelReaderService readerService;
    // private final ExcelWriterService writerService;
    // private final PricingService pricingService;

    // @Override
    // public void run(String... args) {

    // String inputPath =
    // "C:/Users/dogac/Desktop/cloudParts/Ürünleriniz_10.02.26-13.14.xlsx";

    // String outputPath = "C:/Users/dogac/Desktop/cloudParts/output.xlsx";

    // List<ProductRow> products = readerService.read(inputPath);

    // System.out.println("************");
    // products.stream()
    // .map(p -> p.getPrice()).limit(10) // p -> p.getBarcode() ile aynı
    // .forEach(System.out::println);

    // pricingService.applyPrices(products);

    // System.out.println("************");
    // products.stream()
    // .map(p -> p.getPrice()).limit(10) // p -> p.getBarcode() ile aynı
    // .forEach(System.out::println);
    // writerService.writeProductExcel(products, outputPath);

    // System.out.println("Excel oluşturuldu: " + outputPath);
    // }
}
