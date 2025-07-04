package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//可寫三種
	@Query(value = "select user_id, username, password_haah, salt, email, active, role from users where username=:username", nativeQuery = true)
	User getUser(String username);	

}
