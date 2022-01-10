package com.example.promotionEngine.service.impl;

import com.example.promotionEngine.model.Order;
import com.example.promotionEngine.model.Promotion;
import com.example.promotionEngine.service.PriceService;
import com.example.promotionEngine.service.PromotionService;
import com.example.promotionEngine.utils.Constant;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class PriceServiceImpl implements PriceService {

    final PromotionService promotionService;

    private BigDecimal totalPrice;

    public PriceServiceImpl(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Override
    public BigDecimal getTotalPrice(List<Order> orderList) {
        totalPrice = new BigDecimal(0);
        Map<String, Promotion> promotionRules = promotionService.getPromotionRules();

        orderList.forEach(item -> {
            String skuId = item.getSkuId();

            //Scenario A
            if (promotionRules.get(skuId) == null || item.getQuantity() < promotionRules.get(skuId)
                    .getPromotionQuantity()) {
                totalPrice = totalPrice.add(Constant.itemPriceMap.get(skuId).getPrice());
            } else {
                //Scenario B
                //Calculate promotion price
                int numAppliedPromotion = item.getQuantity() / promotionRules.get(skuId).getPromotionQuantity();
                BigDecimal promotionPrice = promotionRules.get(skuId).getPromotionPrice()
                        .multiply(BigDecimal.valueOf(numAppliedPromotion));

                //calculate normal price
                int numNotAppliedPromotion = item.getQuantity() % promotionRules.get(skuId).getPromotionQuantity();
                BigDecimal normalPrice = Constant.itemPriceMap.get(skuId).getPrice()
                        .multiply(BigDecimal.valueOf(numNotAppliedPromotion));

                //sum all prices
                totalPrice = totalPrice.add(promotionPrice.add(normalPrice));
            }
        });

        //Scenario C
        totalPrice = promotionService.getPromotionPriceForCombinedItem(orderList, totalPrice);
        return totalPrice;
    }
}
