package com;

import java.util.HashMap;
import java.util.Map;

public class Basket {

	private Map<String, Integer> skuQuantity = new HashMap<String, Integer>();

	public Map<String, Integer> getSkuQuantity() {
		return skuQuantity;
	}

	public void setSkuQuantity(Map<String, Integer> skuQuantity) {
		this.skuQuantity = skuQuantity;
	}

	public void increaseQuantity(String skuToIncrement) {
		Integer quantity = skuQuantity.get(skuToIncrement);
		if (quantity == null) {
			quantity = 0;
		}
		quantity++;// increment by one
		skuQuantity.put(skuToIncrement, quantity);

	}

}
