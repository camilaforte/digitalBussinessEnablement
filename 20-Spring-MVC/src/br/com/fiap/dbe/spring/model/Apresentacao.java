package br.com.fiap.dbe.spring.model;

import java.io.Serializable;

public class Apresentacao implements Serializable{

	
	private static final long serialVersionUID = 6941388497110478012L;
	
	private int codigo;
	private String nome;
	private int duracao;
	private String descricao;
	private boolean apresentado;

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

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isApresentado() {
		return apresentado;
	}

	public void setApresentado(boolean apresentado) {
		this.apresentado = apresentado;
	}

}
