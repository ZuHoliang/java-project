package com.example.demo.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
	private Integer userId;
	private String accountId;
	private String userName;
	private String role;
	private Boolean active;
//	private String email;

}
