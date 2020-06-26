package br.com.brandao.welcome.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
	
	@GetMapping
	public String getWelcomeTerm() {
		return "Ola";
	}
}
