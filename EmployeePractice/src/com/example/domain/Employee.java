package com.example.domain;

import java.text.NumberFormat;

public abstract class Employee {
	private static int nextId = 1;
	private int empId;
	private String name;
	private String ssn;
	private double salary;
	private Branch branch;
	protected NumberFormat Salary = NumberFormat.getInstance();

	
	public Employee(String name, String ssn, double salary, Branch branch) {
		this.empId = nextId++;
		this.name = name;
		this.ssn = ssn;
		this.branch = branch;
		if(salary>=28590) {
			this.salary = salary;
		} else {
			System.out.println("薪水須符合最低薪資!");
			this.salary = 28590;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (empId != other.empId) {
			return false;
		}
		if (ssn == null) {
			if (other.ssn != null) {
				return false;
			}
		} else if (!ssn.equals(other.ssn)) {
			return false;
		}
		return true;
	}
	

	public int getEmpId() {
		return this.empId;		
	}
	
	public String getName() {
		return name;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public abstract double getPay();
	
	public void setName(String name) {
		if(name != null && name.trim().length()!=0)
			this.name=name;
	}
	
	public void raiseSalary(double increase) {
		if(increase>0) {
			this.salary += increase;
		} else {
			System.out.println("加薪請大於0");
		}
	}
	

	@Override
	public String toString() {
		return "\n======員工資料======\n"+
				"分公司:"+this.branch+"\n"+
				"員工編號:"+ String.format("%03d", this.empId)+"\n"+
				"員工姓名:"+ this.name+"\n"+
				"SSN:"+ this.ssn+"\n"+
				"員工薪水:"+this.branch.getCurrency()+ Salary.format(salary)+"\n"+					
				"年終獎金:"+this.branch.getCurrency()+ Salary.format(getPay())+"\n";
	}
}



