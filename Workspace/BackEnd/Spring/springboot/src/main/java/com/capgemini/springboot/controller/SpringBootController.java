package com.capgemini.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

	@GetMapping(path = "/hello", produces = "text/plain")
	public String welcomeMessage() {
		return "Welcome to SpringBoot!!";
	}// End of welcomeMessage()

}// End of Controller
