package com.cloudparts.cloudparts_pricing.service;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.cloudparts.cloudparts_pricing.model.ProductRow;

@Service
public class ExcelReaderService {
    public List<ProductRow> read(String filePath) {

        List<ProductRow> products = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            // 0 = header, 1'den başlıyoruz
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null)
                    continue;

                ProductRow product = new ProductRow();
                product.setProductName(getString(row.getCell(0)));
                product.setBarcode(getString(row.getCell(1)));
                product.setCategory(getString(row.getCell(2)));
                product.setPrice(getBigDecimal(row.getCell(3)));
                product.setDiscountPrice(getBigDecimal(row.getCell(4)));
                product.setStock(getInteger(row.getCell(5)));
                product.setStockCode(getString(row.getCell(6)));

                products.add(product);
            }

        } catch (Exception e) {
            throw new RuntimeException("Excel okunamadı", e);
        }

        return products;
    }

    private String getString(Cell cell) {
        if (cell == null)
            return null;
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue().trim();
    }

    private BigDecimal getBigDecimal(Cell cell) {
        if (cell == null)
            return BigDecimal.ZERO;
        return BigDecimal.valueOf(cell.getNumericCellValue());
    }

    private Integer getInteger(Cell cell) {
        if (cell == null)
            return 0;
        return (int) cell.getNumericCellValue();
    }
}
