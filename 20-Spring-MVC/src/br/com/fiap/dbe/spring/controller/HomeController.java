package br.com.fiap.dbe.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

	@GetMapping("/")
	public String home() {
		System.out.println("Entrou!");
		return "home/index";
	}
}
