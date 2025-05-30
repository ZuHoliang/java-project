package com.example;

public class Cat extends Animal implements Pet {

	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat() {
		this(" ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void play(){
		System.out.println((name.length()==0?"貓":name)+"玩毛線球");
	}

	@Override
	public void eat() {
		if(name!=null && name.length()!=0)
			System.out.println(name+"最喜歡吃魚");
		else
			System.out.println("貓最喜歡吃魚");			
	}

}
