package case02;

import java.util.ArrayList;
import java.util.List;

public class GuestbookMain {
	
	private static List<Guestbook> guestbook = new ArrayList<>();

	public static void main(String[] args) {
		
		Guestbook g1 = new Guestbook("Hello");
		guestbook.add(g1);
		System.out.println(guestbook);
		
		Guestbook g2 = new Guestbook("Hello2");
		guestbook.add(g2);
		System.out.println(guestbook);
		
	}

}
