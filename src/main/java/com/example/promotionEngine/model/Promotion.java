package com.example.promotionEngine.model;

import java.math.BigDecimal;

public class Promotion {
    private String skuId;
    private int promotionQuantity;
    private BigDecimal promotionPrice;

    public Promotion(String skuId, int promotionQuantity, BigDecimal promotionPrice) {
        this.skuId = skuId;
        this.promotionQuantity = promotionQuantity;
        this.promotionPrice = promotionPrice;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public void setPromotionQuantity(int promotionQuantity) {
        this.promotionQuantity = promotionQuantity;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }
}
