package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("contato/")
public class ContatoController {

	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	//ou uso @GetMapping ("enviar")
	public String cadastrarContato() {
		return "contato/contato";
	}

	// metodo que recupera as informações do formulario
	// parametros que quero receber neste caso nome e msg, mesmo nome do name do
	// input do formulario
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	//ou uso assim @PostMapping ("enviar")
	public String contato(String nome, String mensagem) {
		System.out.println(nome + " " + mensagem);
		return "contato/contato";
	}
}
