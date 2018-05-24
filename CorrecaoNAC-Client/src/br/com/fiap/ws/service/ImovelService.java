package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Imovel;

public class ImovelService {

	// 1º roda o server acrescente /rest/imovel, copia e cola na url
	//type manda um json (dado)
	//accept aceita um json (dado)

	// criar uma constante url

	private static final String URL = "http://localhost:8080/CorrecaoNAC-Server/rest/imovel";

	// criar a requisição, conexao com o web service
	private Client cliente = Client.create();

	// cadastrar .type e .post
	public void cadastrar(Imovel imovel) throws Exception {
		// chamar o webservice
		WebResource resource = cliente.resource(URL);
		// esta com a resposta pra devolver
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, imovel);
		// validar se for ok
		if (resp.getStatus() != 201) {
			throw new Exception("Erro ao cadastrar" + resp.getStatus());
		}
	}

	// listar .accept e .get
	public List<Imovel> listar() throws Exception {
		// chamar o webservice
		WebResource resource = cliente.resource(URL);
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		// validar se for ok
		if (resp.getStatus() != 200) {
			throw new Exception("Erro ao listar" + resp.getStatus());
		}
		// retornar lista de imoveis
		return Arrays.asList(resp.getEntity(Imovel[].class));
	}

	// atualizar .type e .put
	public void atualizar(Imovel imovel) throws Exception {
		//chamar o webservice
		WebResource resource = cliente.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class);
		// validar se for ok
		if(resp.getStatus() != 200) {
			throw new Exception("Erro ao atualizar" + resp.getStatus());
		}
	}

	// deletar .delete
}
