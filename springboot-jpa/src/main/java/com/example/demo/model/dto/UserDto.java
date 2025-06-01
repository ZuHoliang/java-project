package com.example.demo.model.dto;

import lombok.Data;
import lombok.ToString;

//屬性名稱可以已與所對應的entity不同
@Data
public class UserDto {
	
	private Integer userId;
	private String username;
	private String email;
	private String role;
	private Boolean active;

}
