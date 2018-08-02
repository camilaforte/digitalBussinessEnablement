package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// metodo que atende uma requisição
	@RequestMapping("/home")
	public String home() {
		// retorna a view (pasta e arquivo)
		///WEB-INF/jsp/home/index.jsp
		return "home/index";
	}

	
	
}
