package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class UserCert {
	private Integer userId;
	private String accountId; 	//帳號
	private String username;	//名稱
	private String role;		//權限

}
