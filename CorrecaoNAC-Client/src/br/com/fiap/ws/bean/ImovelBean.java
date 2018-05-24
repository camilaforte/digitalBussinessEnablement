package br.com.fiap.ws.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.fiap.ws.service.ImovelService;
import br.com.fiap.ws.to.Imovel;

@ManagedBean
public class ImovelBean {
	 
	//da tela pro webservice e do webservice pra tela
	
	private Imovel imovel;
	//nao precisa de get e set pq só será utilizado nesta classe
	private ImovelService service;
	
	//metodo de inicialização
	@PostConstruct
	private void init() {
		imovel = new Imovel();
		service = new ImovelService();
	}
	
	//metodo pro clique do botao
	public String cadastrar() {
		FacesMessage msg;
		try {
			service.cadastrar(imovel);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar");
		}
		//coloca a msg no contexto
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//manter a msg apos redirecionamento
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		//redirecionar para nao ficar cadastrando com f5
		return "imovel?faces-redirect=true";
	}
	
	public List<Imovel> getListar(){
		FacesMessage msg;
		
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao listar");
			return null;
		}
	}
	
	
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
}
