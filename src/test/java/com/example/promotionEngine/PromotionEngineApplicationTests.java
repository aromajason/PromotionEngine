package com.example.promotionEngine;

import com.example.promotionEngine.service.PriceService;
import com.example.promotionEngine.utils.Constant;
import com.example.promotionEngine.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class PromotionEngineApplicationTests {

	@Autowired
	PriceService priceService;

	@Test
	public void scenarioA() {
		List<Order> orderProductList = new ArrayList<>();
		orderProductList.add(new Order(Constant.SKU_A, 1));
		orderProductList.add(new Order(Constant.SKU_B, 1));
		orderProductList.add(new Order(Constant.SKU_C, 1));
		BigDecimal totalPrice = priceService.getTotalPrice(orderProductList);
		Assertions.assertEquals(totalPrice, new BigDecimal(100));
	}

	@Test
	public void scenarioB() {
		List<Order> orderProductList = new ArrayList<>();
		orderProductList.add(new Order(Constant.SKU_A, 5));
		orderProductList.add(new Order(Constant.SKU_B, 5));
		orderProductList.add(new Order(Constant.SKU_C, 1));
		BigDecimal totalPrice = priceService.getTotalPrice(orderProductList);
		Assertions.assertEquals(totalPrice, new BigDecimal(370));
	}

	@Test
	public void scenarioC() {
		List<Order> orderProductList = new ArrayList<>();
		orderProductList.add(new Order(Constant.SKU_A, 3));
		orderProductList.add(new Order(Constant.SKU_B, 5));
		orderProductList.add(new Order(Constant.SKU_C, 1));
		orderProductList.add(new Order(Constant.SKU_D, 1));
		BigDecimal totalPrice = priceService.getTotalPrice(orderProductList);
		Assertions.assertEquals(totalPrice, new BigDecimal(280));
	}
}
