package br.com.fiap.dbe.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="T_PRODUTO_SPRING")
@SequenceGenerator (name = "produto",  sequenceName = "SQ_T_PRODUTO", allocationSize=1)
public class Produto implements Serializable{

	@Transient
	private static final long serialVersionUID = -323114134751507020L;

	@Id
	@GeneratedValue (generator = "produto", strategy=GenerationType.SEQUENCE)
	@Column(name = "cd_produto")
	private int codigo;
	
	@Column(name = "nm_produto", length=100, nullable=false)
	private String nome;
	
	@Column(name = "vl_produto", nullable=false)
	private double preco;
	
	@Column(name = "st_perecivel", nullable=false)
	private boolean perecivel;
	
	public Produto() {
	}

	public Produto(String nome, double preco, boolean perecivel) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.perecivel = perecivel;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isPerecivel() {
		return perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	
	
	
	
}
