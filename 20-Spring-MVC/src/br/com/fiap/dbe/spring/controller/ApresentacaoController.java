package br.com.fiap.dbe.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dbe.spring.model.Apresentacao;

@Controller
@RequestMapping ("apresentacao") //url entidade
public class ApresentacaoController {

	//url metodo
	@GetMapping ("/cadastro")
	public String abrirPaginaCadastro() {
		System.out.println("Cadastrado!");
		return "home/cadastro";
	}
	
	@PostMapping ("/cadastro")
	public ModelAndView cadastrar(Apresentacao ap) {
		System.out.println("Cadastrado POST!");
		ModelAndView mv = new ModelAndView("home/cadastro");
		mv.addObject("msg", "Apresentação agendada!");
		return mv;
	}
	
	
}
