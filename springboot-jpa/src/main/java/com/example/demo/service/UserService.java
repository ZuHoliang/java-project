package com.example.demo.service;

import com.example.demo.model.dto.UserDto;

public interface UserService {
	
	public UserDto getUser(String username);
	public void addUser(String username, String password, String email, Boolean active, String role);
//	public void UpdateUser(String username, String password, String email, Boolean active, String role);
//以下自訂
}
