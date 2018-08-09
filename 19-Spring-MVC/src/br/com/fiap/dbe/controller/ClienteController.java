package br.com.fiap.dbe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dbe.model.Cliente;

@Controller
@RequestMapping ("cliente")				//mapeia url para um metodo qlq por padrao get
public class ClienteController {

	@GetMapping("cadastrar")			//mapeia url pelo metodo a ser chamado
	public String abrirPaginaDeCadastro() {
		return "cliente/form";			//pagina que será retornada qdo a url for 'chamada' pasta + pagina
	}
	
	@PostMapping("cadastrar")
	//ModelAndView para mandar 
	public ModelAndView cadastrarCliente(Cliente c) {
		
		System.out.println(c.getNome());
		System.out.println(c.getIdade());
		System.out.println(c.isHabilitado());
		System.out.println(c.getGenero());
		//objeto de retonro (pasta neste caso + pagina)
		ModelAndView retorno = new ModelAndView("sucesso");
		//valores que serão enviados para a pagina
		retorno.addObject("cli",c);
		retorno.addObject("msg", "Cliente cadastrado!");
		return retorno;		//para qual pagina será direcionado apos chamar esse metodo (chamado pelo botao do form)
	}
	
}
