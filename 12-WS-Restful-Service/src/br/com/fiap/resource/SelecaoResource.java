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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.dbe.entity.Selecao;
import br.com.fiap.jpa.dao.SelecaoDAO;
import br.com.fiap.jpa.dao.impl.SelecaoDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/selecao")
public class SelecaoResource {

	// crio um dao, sem ele webservice n�o funciona
	private SelecaoDAO dao;

	// inicializo o dao no construtor, com entity
	public SelecaoResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new SelecaoDAOImpl(em);
	}

	@GET // pesquisar
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Selecao pesquisar(@PathParam("id") int codigo) {
		return dao.pesquisar(codigo);
	}
	
	@GET //listar
	//sem path
	@Produces(MediaType.APPLICATION_JSON)
	public List<Selecao> listar(){
		return dao.listar();
	}
	
	@PUT	//atualizar
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Selecao selecao, @PathParam("id") int codigo) {
		try {
			selecao.setCodigo(codigo);
			dao.atualizar(selecao);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	

	@POST	//cadastrar
	@Consumes(MediaType.APPLICATION_JSON)	//devolve uma Response
	public Response cadastrar (Selecao selecao, @Context UriInfo uri) {
		
		try {
			dao.inserir(selecao);
			dao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			//Code 500
			return Response.serverError().build();
			//ou throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR)
		}
		
		//construir url de resposta, retoran status 201
		//recupera URL
		UriBuilder b = uri.getAbsolutePathBuilder();
		//adiciona o codigo da sele��o na URL
		b.path(String.valueOf(selecao.getCodigo()));
		//Retorna status 201 com a URL para acessar a sele��o
		return Response.created(b.build()).build();
	}
	
	@DELETE		//deletar
	@Path("{id}")
	public void delete(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
	}
	


	

}
