package br.com.fiap.ead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.ead.model.Convidado;
import br.com.fiap.jpa.dao.ConvidadoDAO;

@Controller
@RequestMapping("convidado")			//isso vai na url
public class ConvidadoController {

	@Autowired
	private ConvidadoDAO dao;
	
	//cadastrar
	@GetMapping("cadastrar") //isso vai na url
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("convidado/cadastro");
		mv.addObject("convidado", new Convidado());
		return mv;		//caminho da minha pagina jsp
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public String processarForm(Convidado convidado, RedirectAttributes r) {
		dao.inserir(convidado);
		r.addFlashAttribute("msg", "Convidado registrado!");
		return "redirect:/convidado/cadastrar";			//redirecionar vc passa o mapeamento do metodo
	}
	
	
	//listar
	
}
