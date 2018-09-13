package br.com.fiap.ead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@GetMapping("/")		//nao digito nada
	public String home() {
		return "home/index"; //pasta home, pagina indes
	}
	
	@PostMapping("")
	public ModelAndView home(Object o) {
		ModelAndView md = new ModelAndView("");
		
		return md;
	}
	
}
