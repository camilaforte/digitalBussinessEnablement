package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.PacienteDAO;
import br.com.fiap.jpa.dao.impl.PacienteDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/paciente")
public class PacienteResource {

	private PacienteDAO dao;

	//construtor que inicializa
	public PacienteResource(PacienteDAO dao) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacienteDAOImpl(em);
	}
	
	@GET
	public List<Paciente> listar() {
		return dao.listar();
	}
	
//	@Post, Put, Delete fazer estes
}
