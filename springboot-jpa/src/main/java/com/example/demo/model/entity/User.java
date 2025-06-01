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
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;
	@Column(name = "password_hash", unique = false, nullable = false, length = 255)
	private String passwordHash;
	@Column(name = "salt", unique = false, nullable = false, length = 255)
	private String salt;
	@Column(name = "email", unique = true, nullable = false, length = 255)
	private String email;
	@Column(name = "active", unique = true, nullable = false, length = 255)
	private Boolean active;
	@Column(name = "role")
	private String role;

}
