import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CarTest {
	static List car = new LinkedList();
	static Set carBrand = new TreeSet();
	
	private static void PrintCars() {
		System.out.println("現有品牌:"+carBrand);
		System.out.println("現有車輛:"+car);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(car.size()<8) {
			System.out.print("輸入汽車品牌:");
			String newCar = sc.nextLine();
			car.add(newCar);
			boolean isNewBrand = carBrand.add(newCar);
			if(isNewBrand) {
				System.out.println("新增品牌:"+newCar);
			} else {
				System.out.println("已有品牌:"+newCar);
			}
		}
		PrintCars();
		System.out.print("輸入欲購買品牌(輸入'Q'離開):");
		String buyCar = sc.nextLine();
		while (!buyCar.equalsIgnoreCase("Q")&& !car.isEmpty()) {
			if(carBrand.contains(buyCar)) {
				int idx = car.indexOf(buyCar);
				System.out.println("請至"+idx+"車庫買車");
				car.remove(idx);
				if(!car.contains(buyCar)) {
					carBrand.remove(buyCar);
				}
				System.out.println(buyCar+"已銷售");
			} else {
				System.out.println("未銷售"+buyCar);
			}
			System.out.print("輸入欲購買品牌(輸入'Q'離開):");
			buyCar = sc.nextLine();
		}
		PrintCars();
	}

}
