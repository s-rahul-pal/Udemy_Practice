package com.example.restpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DeoRestController {

//	add code for /hello endpoint
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
