package br.com.fiap.ads.dbe.aula07.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.dbe.to.Selecao;

public class SelecaoService {

	// acessar web service, precisamos do client
	private Client client = Client.create();

	private static final String URL = "http://localhost:8080/12-WS-Restful-Service/rest/selecao";

	public List<Selecao> listar() throws Exception {
		// acessar web service, precisamos do client
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// valida resposta do servidor - status HTTP 200 ok
		if (response.getStatus() != 200) {
			throw new Exception("Erro:" + response.getStatus());
		}
		// recupera as seleções e retorna
		return Arrays.asList(response.getEntity(Selecao[].class));
	}

	public void cadastrar(Selecao selecao) throws Exception {


		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, selecao);

		if (response.getStatus() != 201) {
			throw new Exception("Erro: " + response.getStatus());
		}

	}
	
	public void atualizar(Selecao selecao, int codigo) throws Exception {
		
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, selecao);
		
		if(response.getStatus() != 200) {
			throw new Exception("Erro: " + response.getStatus());
		}
	
	
	}
	
	
	public void	deletar(int codigo) throws Exception {
		
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
	
	public Selecao buscar(int codigo) throws Exception {
														//adiciona o codigo na URL
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200) {
			throw new Exception("Erro: " + response.getStatus());
		}
		return response.getEntity(Selecao.class);
	}
}
