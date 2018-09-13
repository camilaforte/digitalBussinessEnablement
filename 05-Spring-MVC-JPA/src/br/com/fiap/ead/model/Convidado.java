package br.com.fiap.ead.model;

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
@Table(name="T_CONVIDADO")
@SequenceGenerator (name="convidado", sequenceName="SQ_T_CONVIDADO", allocationSize=1)
public class Convidado implements Serializable{

	
	@Transient
	private static final long serialVersionUID = 2061095128323536584L;
	@Id
	@Column(name="cd_convidado")
	@GeneratedValue(generator="convidado", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="nm_condidado", nullable=false, length=100)
	private String nome;
	@Column(name="st_confimado")
	private boolean confirmado;
	@Column(name="ds_email", nullable=false, length=200)
	private String email;
	
	
	
	public Convidado() {
		super();
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
	
	
}
