package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator (name = "paciente", sequenceName = "SQ_T_PACIENTE", allocationSize=1 )
public class Paciente implements Serializable {

	private static final long serialVersionUID = -6158855318308987636L;

	@Id
	@GeneratedValue (generator = "paciente", strategy = GenerationType.SEQUENCE)
	@Column (name = "cd_paciente")
	private int codigo;
	
	@Column (name = "nm_paciente")
	private String nome;

	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "st_doador")
	private boolean doador;
	
	

	public Paciente() {
		super();
	}

	public Paciente(int codigo, String nome, Calendar dataNascimento, boolean doador) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.doador = doador;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isDoador() {
		return doador;
	}

	public void setDoador(boolean doador) {
		this.doador = doador;
	}

	
	
}
