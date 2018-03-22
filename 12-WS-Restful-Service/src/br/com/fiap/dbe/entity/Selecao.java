package br.com.fiap.dbe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "TB_SELECAO")
@SequenceGenerator (name = "selecao", sequenceName = "SQ_T_SELECAO", allocationSize = 1)
public class Selecao {

	
	@Id
	@Column (name = "cd_selecao")
	@GeneratedValue (generator = "selecao", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column (name = "nm_selecao", length = 100, nullable = false)
	private String nome;
	
	@Column (name = "st_selecao")
	private boolean classificado;
	
	@Column (name = "qt_mundiais")
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
