package br.com.fiap.ads.dbe.aula07.ws.view;

import java.util.Scanner;

import br.com.fiap.ads.dbe.aula07.ws.service.SelecaoService;
import br.com.fiap.dbe.to.Selecao;

public class CadastroView {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		Selecao selecao = new Selecao();

		System.out.println("Pais");
		selecao.setNome(scn.next() + scn.nextLine());

		System.out.println("Numero de mundiais");
		selecao.setNumeroMundiais(scn.nextInt());

		System.out.println("Classificados:");
		selecao.setClassificado(scn.nextBoolean());

		SelecaoService service = new SelecaoService();

		try {
			service.cadastrar(selecao);
			System.out.println("Cadastrado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		scn.close();
	}
}
