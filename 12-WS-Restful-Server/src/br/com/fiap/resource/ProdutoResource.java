package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.dao.impl.ProdutoDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	private ProdutoDAO dao;

	public ProdutoResource() {
		// inicializo o dao no construtor
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ProdutoDAOImpl(em);
	}

	// @Path("/buscar") posso colocar para aparecer na url
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> listar() {
		return dao.listar();
	}

	// @Path("/cadastrar") posso colocar para aparecer na url
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uri) {
		try {
			dao.inserir(produto);
			dao.commit();
			// construir url de resposta
			UriBuilder b = uri.getAbsolutePathBuilder();
			b.path(produto.getCodigo() + "");
			return Response.created(b.build()).build();

		} catch (CommitException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

	}
/*
	// @Path("/deletar") posso colocar para aparecer na url
	@DELETE
	public void delete() {

	}

	// @Path("/atualizar") posso colocar para aparecer na url
	@PUT
	public ProdutoTO atualizar () {
		return 
	}
*/
}
