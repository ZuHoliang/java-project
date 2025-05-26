package model.ice;

public class IceOrder {
	private MainDish mainDish;
	private Topping topping;
	private int totalPrice;
	
	public IceOrder(String mainDishName, String[] toppArray) {
		this(new MainDish(mainDishName),new Topping(toppArray));		
	}
	
	public IceOrder(MainDish mainDish, Topping topping) {
		this.mainDish=mainDish;
		this.topping=topping;
		this.totalPrice = mainDish.getPrice()+topping.calculateToppingPrice();
	}

	public MainDish getMainDish() {
		return mainDish;
	}

	public Topping getTopping() {
		return topping;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
}
