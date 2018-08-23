package br.com.fiap.dbe.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dbe.jpa.dao.ProdutoDAO;
import br.com.fiap.dbe.jpa.model.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	// cadastro produto
	// pg com template
	@Autowired
	private ProdutoDAO dao;

	@GetMapping("cadastrar")
	public String cadastrar() {
		System.out.println("Pagina abriu");
		return "produto/cadastrar";
	}

	@Transactional // quando preciso de commit, transação
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(Produto produto) {
		System.out.println("Produto cadastrado");
		dao.inserir(produto);
		ModelAndView mv = new ModelAndView("produto/cadastrar");
		mv.addObject("msg", "Produto cadastrado!");
		return mv;
	}

	@GetMapping("listar")
	public ModelAndView listar() {
		System.out.println("Listando");
		ModelAndView mv = new ModelAndView("produto/listar");
		List<Produto> produtos = dao.listar();
		mv.addObject("tabela", produtos);
		System.out.println(produtos.size());
		return mv;
	}

}
