package case03;

public class IceOrder {
	private MainDish mainDish;
	private Topping topping;
	private int tatalPrice;
	
	public IceOrder(String mainDishName, String[] toppArray) {
		this(new MainDish(mainDishName),new Topping(toppArray));		
	}
	
	public IceOrder(MainDish mainDish, Topping topping) {
		this.mainDish=mainDish;
		this.topping=topping;
		this.tatalPrice = mainDish.getPrice()+topping.calculateToppingPrice();
	}

	public MainDish getMainDish() {
		return mainDish;
	}

	public Topping getTopping() {
		return topping;
	}

	public int getTatalPrice() {
		return tatalPrice;
	}
	
}
