package br.com.fiap.dbe.inventario.Estoque;

import java.io.Serializable;

public class ProdutoTO implements Serializable{
	
	private int codigo;
	private String nome;
	private String descricao;
	private int qti;
	private double preco;
	
	public ProdutoTO() {
		super();
	}

	public ProdutoTO(int codigo, String nome, String descricao, int qti, double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.qti = qti;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQti() {
		return qti;
	}

	public void setQti(int qti) {
		this.qti = qti;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
	
	