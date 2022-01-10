package com.example.promotionEngine.service.impl;

import com.example.promotionEngine.model.Order;
import com.example.promotionEngine.model.Promotion;
import com.example.promotionEngine.service.PromotionService;
import com.example.promotionEngine.utils.Constant;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    Map<String, Promotion> promotionMap = new HashMap<>();

    @Override
    public Map<String, Promotion> getPromotionRules() {
        promotionMap.put(Constant.SKU_A, new Promotion(Constant.SKU_A, 3, new BigDecimal(130)));
        promotionMap.put(Constant.SKU_B, new Promotion(Constant.SKU_B, 2, new BigDecimal(45)));
        return promotionMap;
    }

    @Override
    public BigDecimal getPromotionPriceForCombinedItem(List<Order> orderList, BigDecimal totalPrice) {
        List<String> itemList = orderList.stream()
                .map(Order::getSkuId)
                .collect(Collectors.toList());

        if (itemList.contains(Constant.SKU_C) && itemList.contains(Constant.SKU_D)) {
            totalPrice = totalPrice.subtract(new BigDecimal(5));
        }
        return totalPrice;
    }
}
