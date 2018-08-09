package br.com.fiap.dbe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dbe.model.Carro;

@Controller
@RequestMapping ("carro")
public class CarroController {
	
	@GetMapping ("cadastrar")
	public String cadatrar() {
		System.out.println("caiu na carro");
		return "carro/form";
	}
	
	@PostMapping ("cadastrar")
	public ModelAndView cadastrar(Carro c) {
		//ja posso informar para qual pagina eu vou enviar o meu pacotinho
		ModelAndView pacotinho = new ModelAndView("carro/sucesso");

		pacotinho.addObject("carro", c);
		pacotinho.addObject("msg", "Carro cadastrado com sucesso!");
//		pacotinho.addObject("modelo", c.getModelo());
//		pacotinho.addObject("marca", c.getMarca());
//		pacotinho.addObject("novo", c.isNovo());
//		pacotinho.addObject("cambio", c.getCambio());
//		pacotinho.addObject("ano", c.getAno());
		
		return pacotinho;
	}

}
