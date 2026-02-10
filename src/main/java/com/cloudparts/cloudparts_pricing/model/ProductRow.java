package com.cloudparts.cloudparts_pricing.model;

import java.math.BigDecimal;

public class ProductRow {

    // A
    private String productName;

    // B
    private String barcode;

    // C
    private String category;

    // D (Pazarama’daki mevcut fiyat – şimdilik sadece okuyoruz)
    private BigDecimal price;

    // E
    private BigDecimal discountPrice;

    // F
    private Integer stock;

    // G (Bosch’ta sorguladığın kod)
    private String stockCode;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

}
