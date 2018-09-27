package br.com.fiap.spring05mvcjpa.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="T_CONVIDADO")
@SequenceGenerator(name="convidado", sequenceName="SQ_T_CONVIDADO", allocationSize=1, initialValue=1)
public class Convidado {

	@Id
	@GeneratedValue(generator="convidado", strategy=GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="nm_convidado", nullable=false, length=200)
	private String nome;
	
	@Column(name="st_confirmado", nullable=false)
	private boolean confirmado;
	
	@Column(name="ds_email", nullable=false, unique=true)
	private String email;
	
	//SUPER IMPORTANTE JOAO NÃO TEM ESSA PARTE
	@DateTimeFormat(pattern="dd/MM/YYYY")
	private Calendar dataAniversario;
	

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

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Calendar dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
}
