package com;

public class SpecialPrice {

	private Integer quantity;
	private Integer price;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SpecialPrice [quantity=" + quantity + ", price=" + price + "]";
	}

}
