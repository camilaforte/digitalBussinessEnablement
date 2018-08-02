package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SegundaController {

	//o que eu chamo pela URL
	@RequestMapping("/segundaPagina")
	public String segundaPagina() {
		System.out.println("Entrou!");
		//caminho da minha pagina jsp
		return"contato/segundaPagina";
	}
	
}
