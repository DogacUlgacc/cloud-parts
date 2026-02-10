package com.cloudparts.cloudparts_pricing.runner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cloudparts.cloudparts_pricing.model.ProductRow;
import com.cloudparts.cloudparts_pricing.service.ExcelReaderService;

@Component
public class PricingRunner implements CommandLineRunner {

    private final ExcelReaderService excelReaderService;

    public PricingRunner(ExcelReaderService excelReaderService) {
        this.excelReaderService = excelReaderService;
    }

    @Override
    public void run(String... args) {

        Path path = Paths.get(
                "C:", "Users", "dogac", "Desktop", "cloudParts",
                "Ürünleriniz_10.02.26-13.14.xlsx");

        String filePath = path.toString(); // kendi yolunu yaz excell tablosunun

        List<ProductRow> products = excelReaderService.read(filePath);

        products.stream().limit(100).forEach(p -> System.out.println(
                "Barkod: " + p.getBarcode() +
                        " | StokKodu: " + p.getStockCode() +
                        " | Fiyat: " + p.getPrice()));

        System.out.println("Toplam ürün: " + products.size());
    }
}
