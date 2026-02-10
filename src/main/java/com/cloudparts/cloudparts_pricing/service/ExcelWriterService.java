package com.cloudparts.cloudparts_pricing.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.cloudparts.cloudparts_pricing.model.ProductRow;

@Service
public class ExcelWriterService {
    public void writeProductExcel(List<ProductRow> products, String outputPath) {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Products");

            // 1️⃣ Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Ürün Adı");
            header.createCell(1).setCellValue("Barkod");
            header.createCell(2).setCellValue("Kategori");
            header.createCell(3).setCellValue("Fiyat");
            header.createCell(4).setCellValue("İndirimli Fiyat");
            header.createCell(5).setCellValue("Stok");
            header.createCell(6).setCellValue("Stok Kodu");

            // 2️⃣ Data
            int rowIndex = 1;
            for (ProductRow product : products) {
                Row row = sheet.createRow(rowIndex++);

                row.createCell(0).setCellValue(product.getProductName());
                row.createCell(1).setCellValue(product.getBarcode());
                row.createCell(2).setCellValue(product.getCategory());
                row.createCell(3).setCellValue(
                        product.getPrice() != null ? product.getPrice().toPlainString() : "");

                row.createCell(4).setCellValue(
                        product.getDiscountPrice() != null ? product.getDiscountPrice().toPlainString() : "");
                row.createCell(5).setCellValue(product.getStock());
                row.createCell(6).setCellValue(product.getStockCode());
            }

            // 3️⃣ Dosyaya yaz
            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            throw new RuntimeException("Excel yazılırken hata oluştu", e);
        }
    }

}
