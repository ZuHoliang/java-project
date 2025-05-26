package model;

import java.util.Map;

public class CoffeeOrder {
	private String type;
	private String size;
	private boolean sugar;
	private float price;
	

	private static final Map<String, Map<String,Integer>> priceTable = Map.of
			("Latte", Map.of("S", 50, "M", 70, "L", 90),
			 "Mocha", Map.of("S", 45, "M", 55, "L", 65),
			 "Americano", Map.of("S", 40, "M", 45, "L", 60),
			 "Cappuccino", Map.of("S", 55, "M", 80, "L", 100));
	
	private static final Map<String, String> sizeMap = Map.of("S", "小杯", "M", "中杯", "L", "大杯");
	private static final Map<Boolean, String> sugarMap = Map.of(true, "有糖", false, "無糖");
		
	public CoffeeOrder(String type, String size, String sugar) {
		this.type=type;
		this.size=size;
		this.sugar=Boolean.parseBoolean(sugar);
		this.price=priceTable.get(type).get(size);
	}
	
	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public boolean isSugar() {
		return sugar;
	}

	public String getPrice() {
		String sizeTest = sizeMap.get(size);
		String sugarTest = sugarMap.get(sugar);
		return String.format("您點了 %s %s 咖啡(%s)價格:%.1f%n",sizeTest,type,sugarTest,price);
	}
}
