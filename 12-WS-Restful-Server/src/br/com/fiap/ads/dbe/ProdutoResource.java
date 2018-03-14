package br.com.fiap.ads.dbe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produto")
public class ProdutoResource {

	//@Path("/buscar")					posso colocar mas não preciso
	@GET								/*vou buscar*/
	@Produces(MediaType.TEXT_PLAIN)
	public String olaMundo() {
		return "Ola WS Restful";
	}

	
}

