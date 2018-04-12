package br.com.fiap.ads.dbe.aula08.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	private SelecaoService service;			//sem getters and setters
	
	//selecao estará null entao fazemos um construtor
	@PostConstruct
	private void init() {
		selecao = new Selecao();
		service = new SelecaoService();
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
	public void cadastrar() {
		try {
			service.cadastrar(selecao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
