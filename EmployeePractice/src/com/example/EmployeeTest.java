package com.example;

import com.example.domain.*;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] emps = new Employee[5];
		emps[0] = new Admin("一號","A100000000",20000, Branch.Taipei);
		emps[1] = new Admin("二號","Y233452121",30000, Branch.London);
		emps[2] = new Engineer("三號","A200000000",30000, Branch.Paris);
		emps[3] = new Manager("四號","X120000001",35000,"A部門", Branch.Tokyo);
		emps[4] = new Director("五號","O123456789",40000,"B部門",12000, Branch.Taipei);
		
		((Engineer)emps[2]).addSkill("Java");
		((Engineer)emps[2]).addSkill("C");
		
		((Admin)emps[1]).setHours(200);
		
		if(emps[3] instanceof Manager) {
			Manager manager = (Manager)emps[3];
			manager.addEmployee(emps[0]);
			manager.addEmployee(emps[1]);
			manager.addEmployee(emps[2]);
			System.out.print(manager.getName());
			manager.getStaffDetails();
		}
		
		if(emps[4] instanceof Manager) {
			Manager manager2 = (Manager)emps[4];
			manager2.addEmployee(emps[3]);
			System.out.print(manager2.getName());
			manager2.getStaffDetails();
		}
		
		for(int i=0;i<emps.length;i++) 
			System.out.println(emps[i]);
		
		for(int i=0;i<emps.length;i++) {
			System.out.printf("%n%s本月薪資%s%,.0f元%n",emps[i].getName(),emps[i].getBranch().getCurrency(),emps[i].getPay());
			if(emps[i] instanceof RegularStaff) {
				System.out.printf("年終獎金:%s%,.0f%n尾牙抽獎:%s%n",emps[i].getBranch().getCurrency(),((RegularStaff)emps[i]).getBonus(), RegularStaff.getLuckDraw());
				
			}
		}
		
	}
}

