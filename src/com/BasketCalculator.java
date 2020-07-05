package com;

import java.util.Map;
import java.util.Set;

public class BasketCalculator {
	public static void calculateBasket(Basket theBasket, Map<String, SpecialPrice> specialPricesMap,
			Map<String, Integer> normalPricesMap) {

		System.out.println("Subtotal = " + calculateAndReturn(theBasket, specialPricesMap, normalPricesMap));

	}

	public static Integer calculateAndReturn(Basket theBasket, Map<String, SpecialPrice> specialPricesMap,
			Map<String, Integer> normalPricesMap) {

		Integer total = 0;
		Set<String> skus = theBasket.getSkuQuantity().keySet();
		for (String sku : skus) {
			if (specialPricesMap.containsKey(sku)) {
				SpecialPrice sp = specialPricesMap.get(sku);
				Integer spPrice = sp.getPrice();
				Integer spQuantity = sp.getQuantity();
				Integer nmPrice = normalPricesMap.get(sku);
				Integer basketQuantity = theBasket.getSkuQuantity().get(sku);
				Integer remainder = (basketQuantity % spQuantity);
				Integer specialPriceQuantity = (basketQuantity - remainder) / spQuantity;
				total = total + specialPriceQuantity * spPrice;
				if (remainder > 0) {
					total = total + (remainder * nmPrice);
				}

			} else {
				total = total + (normalPricesMap.get(sku) * theBasket.getSkuQuantity().get(sku));
			}

		}

		return total;

	}

}
