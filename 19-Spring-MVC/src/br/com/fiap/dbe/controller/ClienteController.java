package br.com.fiap.dbe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.dbe.model.Cliente;

@Controller
@RequestMapping ("cliente")				//mapeia url para um metodo qlq por padrao get
public class ClienteController {

	@GetMapping("cadastrar")			//mapeia url pelo metodo a ser chamado
	public String abrirCadastro() {
		return "cliente/form";			//pasta + pagina
	}
	
	@PostMapping("cadastrar")
	public String cadastrarCliente(Cliente c) {
		
		System.out.println(c.getNome());
		System.out.println(c.getIdade());
		System.out.println(c.isHabilitado());
		System.out.println(c.getGenero());
		
		return "sucesso";		//para qual pagina será direcionado apos chamar esse metodo (chamado pelo botao do form)
	}
	
}
