package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //(建立資料表)
@Table(name = "users") //資料表命名
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "username", unique = false, nullable = false)
	private String username;
	
	@Column(name = "password_hash", unique = false, nullable = false)
	private String passHash;
	
	@Column(name = "salt", unique = false, nullable = false)
	private String salt;
	
//	@Column(name = "email", nullable = false)
//	private String email;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "active")
	private Boolean active;

}
