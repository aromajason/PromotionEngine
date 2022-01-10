package com.example.promotionEngine.utils;

import com.example.promotionEngine.model.Item;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String SKU_A = "A";
    public static final String SKU_B = "B";
    public static final String SKU_C = "C";
    public static final String SKU_D = "D";
    public static final Map<String, Item> itemPriceMap = initItemPriceMap();

    private static Map<String, Item> initItemPriceMap() {
        Map<String, Item> itemPriceMap = new HashMap<>();
        itemPriceMap.put(SKU_A, new Item(SKU_A, new BigDecimal(50)));
        itemPriceMap.put(SKU_B, new Item(SKU_B, new BigDecimal(30)));
        itemPriceMap.put(SKU_C, new Item(SKU_C, new BigDecimal(20)));
        itemPriceMap.put(SKU_D, new Item(SKU_D, new BigDecimal(15)));
        return itemPriceMap;
    }
}
