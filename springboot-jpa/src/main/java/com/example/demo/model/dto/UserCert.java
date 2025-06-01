package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UserCert {
	
	private Integer userId;
	private String username;
	private String role;
//登入時間 	private Date loginDate;
	
}
