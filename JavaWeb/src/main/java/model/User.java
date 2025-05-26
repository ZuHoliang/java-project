package model;

public class User {
	private String userName;
	private String gender;
	private Integer age;
	private Double height;
	private Double weight;
	private Double bmi;
	
	public User(String userName, String gender, String age, String height, String weight) {
	this.userName=userName;
	this.gender=gender;
	this.age=Integer.parseInt(age);
	this.height=Double.parseDouble(height);
	this.weight=Double.parseDouble(weight);
	this.bmi = this.weight/Math.pow(this.height/100, 2);
	}
	//方法封裝-getter

	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getBmi() {
		return bmi;
	}
	
	public String getDiagnosis() {
//		if(this.gender == "male") {
//			return (this.bmi)<=17.4?"過瘦": (this.bmi)<=23.3? "正常":"過重";
//		} 
//		else {
//			return (this.bmi)<=17.1?"過瘦": (this.bmi)<=22.7? "正常":"過重";
//		}
		switch (gender) {
		case "male": 
			return (this.bmi)<=17.4?"過瘦": (this.bmi)<=23.3? "正常":"過重";
		case "female":
			return (this.bmi)<=17.1?"過瘦": (this.bmi)<=22.7? "正常":"過重";
		}return "";
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", bmi=" + bmi + "]";
	}
	
	
	
	
	
}
