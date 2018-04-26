package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.PacienteDAO;
import br.com.fiap.jpa.dao.impl.PacienteDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/paciente")
public class PacienteResource {

	private PacienteDAO dao;

	//construtor que inicializa
	public PacienteResource(PacienteDAO dao) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacienteDAOImpl(em);
	}
	
	//pesquisar
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Paciente pesquisar(@PathParam("id") int codigo) {
		return dao.pesquisar(codigo);
	}
	
	
	//**********************************************************************
	
	@GET //listar
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> listar() {
		return dao.listar();
	}
	
	
	//**********************************************************************
	
//	@Post, Put, Delete fazer estes
	// devolvo um response sempre com atualizar e cadastrar pois tenho que dar uma resposta na url
	//UriBuilder é para devolver uma url ou seja nos dois casos atualizar e cadastrar
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response cadastrar(Paciente paciente, @Context UriInfo uri) {
		
		try {
			dao.inserir(paciente);
			dao.commit();
		} catch (CommitException e) {
			
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		UriBuilder b = uri.getAbsolutePathBuilder();
		b.path(String.valueOf(paciente.getCodigo()));
		
		
		return Response.created(b.build()).build();
		
	}
	//**********************************************************************
	@PUT
	@Path("{id}")
	@Consumes (MediaType.APPLICATION_JSON)
	public Response atualizar (Paciente paciente, @PathParam("id") int codigo) {
		
		try {
			dao.atualizar(paciente);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}


		return Response.ok().build();
	}
	
	//**********************************************************************
	@DELETE
	@Path("{id}")
	public void delete (@PathParam("id") int codigo) {
		
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			//como sao erros diferentes, trato de forma diferente
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
			//este é um erro de chave e nao de servidor
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
	}
	//**********************************************************************
	
	
}


























