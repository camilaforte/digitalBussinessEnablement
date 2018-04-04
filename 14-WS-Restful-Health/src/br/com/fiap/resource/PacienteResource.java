package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.PacienteDAO;
import br.com.fiap.jpa.dao.impl.PacienteDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("paciente")
public class PacienteResource {

	// atributo privado dao
	private PacienteDAO dao;

	// construtor com entity
	public PacienteResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacienteDAOImpl(em);
	}

	// cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar (Paciente paciente, @Context UriInfo uri) {
		
		try {
			dao.inserir(paciente);
			dao.commit();
			
		}catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		UriBuilder builder = uri.getAbsolutePathBuilder();
		builder.path(String.valueOf(paciente.getCodigo());
		
		
		
		return Response.created(builder.build()).build();
		
	}
	
	//buscar
	@GET
	@Pro
	public Paciente pesquisar(@PathParam("id") int codigo) {
		
		return dao.pesquisar(codigo);
	}

}
