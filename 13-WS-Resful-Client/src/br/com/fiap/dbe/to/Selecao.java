package br.com.fiap.dbe.to;

public class Selecao {

	private int codigo;

	private String nome;

	private boolean classificado;

	private int numeroMundiais;

	public Selecao() {
		super();
	}

	public Selecao(String nome, boolean classificado, int numeroMundiais) {
		super();
		this.nome = nome;
		this.classificado = classificado;
		this.numeroMundiais = numeroMundiais;
	}

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

	public boolean isClassificado() {
		return classificado;
	}

	public void setClassificado(boolean classificado) {
		this.classificado = classificado;
	}

	public int getNumeroMundiais() {
		return numeroMundiais;
	}

	public void setNumeroMundiais(int numeroMundiais) {
		this.numeroMundiais = numeroMundiais;
	}

}
