package com.example.demo.service;

import com.example.demo.model.dto.UserDto;

public interface UserService {
	public UserDto getUser(String accountId);
	public void addUser(String accountId, String userName, String password, String role, Boolean active);
	
	

}
