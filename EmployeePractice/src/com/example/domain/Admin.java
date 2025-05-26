package com.example.domain;

public class Admin extends Employee{
	
	int hours = 160;

	public Admin(String name, String ssn, double salary, Branch branch) {
		super(name, ssn, salary, branch);
	}
	
	
	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getPay() {
		return getSalary()*hours/160;
	}

}
