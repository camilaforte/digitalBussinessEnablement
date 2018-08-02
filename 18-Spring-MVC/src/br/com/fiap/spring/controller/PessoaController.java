package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.spring.entity.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	// este metodo abre a tela, get
	@GetMapping("cadastrar")
	public String cadastrar() {
		System.out.println("Entrou");
		return "pessoa/pessoa";
	}

	// mesmo sendo o mesmo nome do metodo, como não é get ele nao abre pela url,
	// entao ele só é chamado
	// qdo dou o submit do formulario pessoa.jsp, onde coloquei como post o metodo
	// crio um objeto bean, para tirar os parametros e colocar o objeto, imaginando
	// que tenham mtos campos para
	// serem gravados e coloca-los todos como parametros ficaria horrivel
	
	@PostMapping("cadastrar")
	public String cadastrar(Pessoa pessoa) {
		System.out.println(pessoa.getNome() + " " + pessoa.getIdade() + " " + pessoa.isAposentado());
		return "pessoa/pessoa";

	}
	
	/*
	 * @PostMapping("cadastrar") public String cadastrar(String nome, int idade,
	 * boolean aposentado) { System.out.println(nome + " " + idade + " " +
	 * aposentado); return "pessoa/pessoa"; }
	 */
}