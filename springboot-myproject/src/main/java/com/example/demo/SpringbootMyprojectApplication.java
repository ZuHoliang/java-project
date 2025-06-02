package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//啟用WebFilter掃描
@ServletComponentScan 
@SpringBootApplication
public class SpringbootMyprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMyprojectApplication.class, args);
	}

}
