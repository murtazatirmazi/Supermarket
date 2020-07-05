package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Checkout {

	private static Map<String, Integer> productmap = new HashMap<String, Integer>();
	private static Map<String, SpecialPrice> specialpricemap = new HashMap<String, SpecialPrice>();
	private static Basket checkoutBasket = new Basket();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		productmap.put("A", 50);
		productmap.put("B", 30);
		productmap.put("C", 20);
		productmap.put("D", 15);

		getSpecialPrice();
		startCheckout();

	}

	public static void getSpecialPrice() {
		// quanity, enter special for that quantity, sku quantity and the price,

		System.out.println("Type in sku to add to Pricing Rules");
		Scanner input = new Scanner(System.in); // Create a Scanner object
		String userInput = input.nextLine();
		while (!userInput.contains("end")) {
			String SKU = userInput; // Read user input
			System.out.println("SKU is: " + SKU); // Output user input

			System.out.println("Enter Special Price");

			Integer specialPrice = Integer.valueOf(input.nextLine()); // Read user input
			System.out.println("Special Price is: " + specialPrice); // Output user input

			System.out.println("What is the quantity for this Special Price?");
			Integer specialPriceQuantity = Integer.valueOf(input.nextLine()); // Read user input
			System.out.println("Special Price Quantity is: " + specialPriceQuantity); // Output user input

			SpecialPrice Price = new SpecialPrice();
			Price.setPrice(specialPrice);
			Price.setQuantity(specialPriceQuantity);

			specialpricemap.put(SKU, Price);
			System.out.println("Enter next sku for special price or type end to start checkout");
			userInput = input.nextLine();

		}

	}

	public static void startCheckout() {

		System.out.println("Type in the sku to add to basket");
		Scanner input = new Scanner(System.in); // Create a Scanner object
		String userInput = input.nextLine();
		BasketCalculator calculator = new BasketCalculator();
		while (!userInput.contains("end")) {
			String SKU = userInput; // Read user input
			System.out.println("SKU is: " + SKU); // Output user input

			checkoutBasket.increaseQuantity(SKU);
			calculator.calculateBasket(checkoutBasket, specialpricemap, productmap);

			System.out.println("Enter next Sku or type end to exit");
			userInput = input.nextLine();

		}

		Integer total = calculator.calculateAndReturn(checkoutBasket, specialpricemap, productmap);
		System.out.println("Total is: " + total + " in pence.");

	}

}
