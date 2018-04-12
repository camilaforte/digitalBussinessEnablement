package br.com.fiap.ads.dbe.aula08.bean;

import javax.faces.bean.ManagedBean;

//mapeando o @ManagedBean import faces.bean
@ManagedBean 
public class IndexBean {
	

	private String nome;
	private String senha;
	
	public void loga() {
		if(nome.equals("FIAP") && (senha.equals("FIAP2018"))) {
			System.out.println("Logado!");
			System.out.println("Nome: " + getNome());
			System.out.println("Senha: " + getSenha());
		}else{
			System.out.println("Login incorreto");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
