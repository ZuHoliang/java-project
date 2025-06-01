package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CertException;
import com.example.demo.exception.PassWordInvalidException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CertService;
import com.example.demo.service.UserService;
import com.example.demo.util.Hash;

@Service
public class CertServiceImpl implements CertService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserCert getCert(String username, String password) throws CertException {
		// 是否有此人
		User user = userRepository.getUser(username);
		if(user == null) {
			throw new UserNotFoundException("查無此人");
		}
		System.out.println("帳號存在");
		
		//密碼比對
		String passwordHash = Hash.getHash(password, user.getSalt());
		if(!passwordHash.equals(user.getPasswordHash())) {
			throw new PassWordInvalidException("密碼錯誤");
		}
		System.out.println("密碼正確");
		//簽發憑證
		UserCert userCert = new UserCert(user.getUserId(), user.getUsername(), user.getPasswordHash());
		System.out.println("簽發憑證");
		return userCert;
	}

}
