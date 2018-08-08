package br.com.fiap.dbe.model;


public class Cliente {

	private String nome;
	private int idade;
	private boolean habilitado;
	private String genero;
	
	public Cliente(String nome, int idade, boolean habilitado, String genero) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.habilitado = habilitado;
		this.genero = genero;
	}

	public Cliente() {
		super();
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

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
