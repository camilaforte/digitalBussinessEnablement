package br.com.fiap.ads.dbe.bean;

import java.io.Serializable;

public class ProdutoTO implements Serializable{

	
	private static final long serialVersionUID = 7690502117819568105L;
	private int codigo;
	private String nome;
	private double preco;
	private String descricao;
	
	/*construtor*/
	public ProdutoTO() {
		super();
	}
	
	

	public ProdutoTO(int codigo, String nome, double preco, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}



	/*getters setters*/
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
