package com.example.domain;

import java.util.ArrayList;

public class Manager extends Employee implements RegularStaff{
	private String deptName;
	protected ArrayList employees;
	private double baseBonus=100000;

	public Manager(String name, String ssn, double salary, String dept, Branch branch) {
		super(name, ssn, salary, branch);
		this.deptName = dept;
		employees = new ArrayList();
	}

	public String getDeptName() {
		return deptName;
	}
	
	public boolean addEmployee(Employee e) {
		if(!employees.contains(e)) {
			employees.add(e);
			return true;
		}else {
			return false;
		}
	}
	
	public double getBonus() {
		return this.baseBonus*this.calcPerMultiplier();
	}
	
	public boolean removeEmployee(Employee e) {
		if(employees.contains(e)) {
			employees.remove(e);
			return true;
		} else {
			return false;
		}
		
	}
	

	public String getStaffDetails() {
		StringBuilder gt = new StringBuilder();
		if(!employees.isEmpty()) {
			gt.append("管理員工:");
			for(Object obj: employees) {
				if(obj instanceof Employee) {
				Employee e = (Employee)obj;
				gt.append(String.format("%s(%d)",e.getName(),e.getEmpId()));
				}
			}
		}
		return gt.toString();
	}
	
	public double getPay() {
		int Pay = 2000*employees.size();
		return Pay+getSalary();
	}	
	
	
	@Override
	public String toString() {
		String output = super.toString()+"\n管理部門:"+getDeptName();
		if(!employees.isEmpty())
			output += "\n"+this.getStaffDetails();
		return output;
	}

}
