package com.example.domain;

import java.util.Arrays;

public class Engineer extends Employee implements RegularStaff{
	private String skills[] = new String[5];
	private int skillCount = 0;
	

	public Engineer(String name, String ssn, double salary, Branch branch) {
		super(name, ssn, salary, branch);
	}
	
	public void addSkill(String skill) {
		if(skillCount < skills.length) {
		skills[skillCount++] = skill;
		} else {
			System.out.println("最多登記5種技能，登記失敗!");
		}
	}
	
	public double getPay() {
		int Pay = 3000*skillCount;
		return Pay+getSalary();
	}	
	
	public double getBonus() {
		return this.getSalary()*this.calcPerMultiplier();

	}
	
	@Override
	public String toString() {
		StringBuilder br = new StringBuilder(super.toString());
		if(skillCount>0)
			br.append("技能:");
				for(int i = 0; i<skillCount;i++) {
					br.append("-"+skills[i]);
				}
			System.out.println();
		return br.toString();
	}
	
		

}
