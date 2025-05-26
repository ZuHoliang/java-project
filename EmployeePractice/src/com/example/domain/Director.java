package com.example.domain;

public class Director extends Manager {
	private double budget;
	private double baseBonus=500000;
	
	public Director(String name, String ssn, double salary, String dept, double budget, Branch branch) {
		super(name, ssn, salary, dept, branch);
		this.budget = budget;
	}

	public double getBudget() {
		return budget;
	}
	
	public double getBonus() {
		return this.baseBonus*this.calcPerMultiplier();
	}
	
	public double getPay() {
		int Pay = 10000*employees.size();
		return Pay+getSalary();
	}	
	
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"管理預算:"+Salary.format(getBudget());
	}
}
