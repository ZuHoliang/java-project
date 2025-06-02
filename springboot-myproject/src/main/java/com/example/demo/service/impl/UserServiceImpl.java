package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDto getUser(String accountId) {
		User user = userRepository.getUser(accountId);
		if(user == null) {
			return null;
		}
		return userMapper.toDto(user);
	}
	
	public void addUser(String username, String password, String role, Boolean active) {
		String salt = Hash.getSalt();
	}

}
