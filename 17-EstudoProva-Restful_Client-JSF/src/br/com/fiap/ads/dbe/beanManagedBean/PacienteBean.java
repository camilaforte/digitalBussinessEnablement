package br.com.fiap.ads.dbe.beanManagedBean;

import java.util.Calendar;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.fiap.ads.dbe.service.PacienteService;
import br.com.fiap.ads.dbe.to.Paciente;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;

	@PostConstruct
	private void init() {

		paciente = new Paciente();
		// tbm tenho que inicializar a data
		paciente.setDataNascimento(Calendar.getInstance());

	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	//criar o metodo salvar do cadastrar-paciente
	public void salvar() {
		FacesMessage msg;
		try {
			service.cadastrar(paciente);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar1");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
