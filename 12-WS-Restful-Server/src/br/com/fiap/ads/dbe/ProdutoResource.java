package br.com.fiap.ads.dbe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.ads.dbe.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	//@Path("/buscar")					posso colocar mas não preciso
	@GET								/*vou buscar*/
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO criar() {
		return  new ProdutoTO(1, "Coxinha", "Coxinha de frango", 3.5, true);
	}

	
}

