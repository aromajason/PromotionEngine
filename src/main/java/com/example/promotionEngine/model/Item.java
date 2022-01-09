package com.example.promotionEngine.model;

import java.math.BigDecimal;

public class Item {
    private String skuId;
    private BigDecimal price;

    public Item(String skuId, BigDecimal price) {
        this.skuId = skuId;
        this.price = price;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
