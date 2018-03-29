package br.com.fiap.ads.dbe.aula07.ws.view;

import br.com.fiap.ads.dbe.aula07.ws.service.SelecaoService;
import br.com.fiap.dbe.to.Selecao;

public class AtualizaView {

	public static void main(String[] args) {
		
		Selecao selecao = new Selecao("123", true, 30);
		
		SelecaoService service = new SelecaoService();
		try {
			service.atualizar(selecao, 50);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
