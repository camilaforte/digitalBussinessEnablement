package br.com.fiap.ads.dbe.aula07.ws.view;

import java.util.List;

import br.com.fiap.ads.dbe.aula07.ws.service.SelecaoService;
import br.com.fiap.dbe.to.Selecao;

public class ListaView {

	public static void main(String[] args) {
		/*
		 * //acessar web service, precisamos do client Client client = Client.create();
		 * //cria acesso ao web service com a URL WebResource resource =
		 * client.resource("http://localhost:8080/12-WS-Restful-Service/rest/selecao");
		 * //chamar o webservice //accept diz o que quero receber //requisição do tipo
		 * get ClientResponse response =
		 * resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		 * 
		 * //valida a resposta do servidor - 200 OK (Status HTTP)
		 * if(response.getStatus() == 200) { //recuperar a lista de seleção enviada pelo
		 * ws Selecao[] vetor = response.getEntity(Selecao[].class); //Transforma vetor
		 * em lista List<Selecao> lista = Arrays.asList(vetor); //exibir as seleções
		 * 
		 */

		SelecaoService service = new SelecaoService();
		List<Selecao> lista;

		try {
			lista = service.listar();
			for (Selecao selecao : lista) {
				System.out.println(selecao.getNome());
				System.out.println(selecao.getNumeroMundiais());
				System.out.println("*******************************");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
