package com.example.domain;

import java.util.Random;

public interface RegularStaff {
	public static String[] gifts = {"吹風機", "電視機", "電風扇", "咖啡機", "電影票"};
	public static String getLuckDraw() {
		int x =new Random().nextInt(gifts.length);
		return gifts[x];
	}
	
	public default double calcPerMultiplier() {
		return (int)(Math.random()*5+1)*0.5;
	}
	
	public abstract double getBonus();

}
