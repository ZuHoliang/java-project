package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","小明");
		model.addAttribute("now",new Date());
		return "welcome";
	}
}
