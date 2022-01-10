package com.example.promotionEngine.service;

import com.example.promotionEngine.model.Order;
import com.example.promotionEngine.model.Promotion;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PromotionService {
    Map<String, Promotion> getPromotionRules();

    BigDecimal getPromotionPriceForCombinedItem(List<Order> orderList, BigDecimal totalPrice);
}
