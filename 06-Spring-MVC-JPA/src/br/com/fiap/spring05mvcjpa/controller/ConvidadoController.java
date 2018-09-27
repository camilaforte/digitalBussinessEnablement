package br.com.fiap.spring05mvcjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring05mvcjpa.dao.ConvidadoDAO;
import br.com.fiap.spring05mvcjpa.model.Convidado;

@Controller
@RequestMapping("convidado")
public class ConvidadoController {

	@Autowired
	private ConvidadoDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("cadastrar/cadastrar-convidado");
		model.addObject("convidado", new Convidado());
		return model;
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView cadastrar(Convidado convidado, RedirectAttributes rdr) {
		ModelAndView model = new ModelAndView("redirect:/convidado/cadastrar");
		
		try {
			dao.inserir(convidado);
			rdr.addFlashAttribute("msgSucesso", "Convidado cadastrado com sucesso!");
		} catch (Exception e) {
			rdr.addFlashAttribute("msgErro", "Erro ao tentar cadastrar o convidado!");
		}
		
		return model;
	}
	
	@GetMapping("listar")
	public ModelAndView listarConvidados() {
		ModelAndView model = new ModelAndView("listar/lista-convidados");
		model.addObject("convidados", dao.listar());
		return model;
	}
	
	@PostMapping("confirmar-presenca")
	@Transactional		//vai fazer transação, cadastrar atualizar ou exlcuir
	public ModelAndView confirmarPresenca(int codigo, RedirectAttributes redirectAttribute) {
		ModelAndView model = new ModelAndView("redirect:/convidado/listar");
		try {
			dao.confirmar(codigo);
			redirectAttribute.addFlashAttribute("msgSucesso", "Convidado confirmado com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar confirmar a presença do convidado!");
			e.printStackTrace();
		}
		return model;
	}
	
	
	@PostMapping("excluir-convidado")
	@Transactional		//vai fazer transação, cadastrar atualizar ou exlcuir
	public ModelAndView excluir(int codigo, RedirectAttributes redirectAttribute) {
		ModelAndView model = new ModelAndView("redirect:/convidado/listar");
		try {
			dao.remover(codigo);
			redirectAttribute.addFlashAttribute("msgSucesso", "Convidado excluido com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar exlcuir convidado!");
			e.printStackTrace();
		}
		return model;
	}
	
	//@PostMapping("pesquisar") //ver do joao depois
	
	@GetMapping("editar/{id}") //id do convidado
	public ModelAndView abrirForm(@PathVariable("id") int codigo) {
		ModelAndView mod = new ModelAndView("editar/editar");	//nome folder + nome da pagina
		Convidado con = dao.pesquisar(codigo);
		return mod.addObject("convid", con);
	}
	
	@PostMapping("editar-convidado") //msm nome do formulario
	@Transactional						//Redirecti pq vou redirecionar pra pagina do listar, apos a edição
	public ModelAndView editar(Convidado conv, RedirectAttributes red) {
		ModelAndView mod = new ModelAndView("redirect:/convidado/listar");
		dao.atualizar(conv);		
		red.addFlashAttribute("msg", "Convidado atualizado");
		return mod;
	}
	
	@GetMapping("buscar")			//este metodo ainda não pro criado no jsp lista-convidado, fazer um forEach
	public ModelAndView buscar(String nome) {
		ModelAndView mod = new ModelAndView("convidado/lista").addObject("convidados", dao.pesquisarPor(nome));
		return mod;
	}
	
}

//post eu sempre uso Redirect