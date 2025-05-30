package case01;

import java.util.Map;

public class CoffeeOrderMain {

	public static void main(String[] args) {
		/*
		 {Latte: {S:50}, {M:70}, {L:90}}
		 {Mocha: {S:45}, {M:55}, {L:65}}
		 {Americano: {S:40}, {M:45}, {L:60}}
		 {Cappuccino: {S:55}, {M:80}, {L:100}}
		 */
		
		Map<String, Map<String,Integer>> priceTable = Map.of
				("Latte", Map.of("S", 50, "M", 70, "L", 90),
				 "Mocha", Map.of("S", 45, "M", 55, "L", 65),
				 "Americano", Map.of("S", 40, "M", 45, "L", 60),
				 "Cappuccino", Map.of("S", 55, "M", 80, "L", 100));
		
		System.out.println(priceTable);
		
		CoffeeOrder coffeeOrder = new CoffeeOrder("Latte", "M", "true");
		System.out.println(coffeeOrder.getPrice());

	}

}
