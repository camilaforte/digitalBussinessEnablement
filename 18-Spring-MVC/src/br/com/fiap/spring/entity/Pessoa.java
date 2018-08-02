package br.com.fiap.spring.entity;

public class Pessoa {

	private String nome;
	private int idade;
	private boolean aposentado;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, int idade, boolean aposentado) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.aposentado = aposentado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isAposentado() {
		return aposentado;
	}

	public void setAposentado(boolean aposentado) {
		this.aposentado = aposentado;
	}

}
