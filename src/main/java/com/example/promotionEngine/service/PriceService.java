package com.example.promotionEngine.service;

import com.example.promotionEngine.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface PriceService {
    BigDecimal getTotalPrice(List<Order> orderList);
}
