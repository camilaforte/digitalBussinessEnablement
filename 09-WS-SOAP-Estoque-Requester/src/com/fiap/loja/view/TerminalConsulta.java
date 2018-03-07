package com.fiap.loja.view;

import java.util.Scanner;

import br.com.fiap.dbe.inventario.estoque.EstoqueStub;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.BuscarProduto;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.BuscarProdutoResponse;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			EstoqueStub stub = new EstoqueStub();

			BuscarProduto params = new BuscarProduto();
			System.out.println("Digite o código: ");
			params.setCodigo(sc.next() + sc.nextLine());

			BuscarProdutoResponse resp = stub.buscarProduto(params);

			ProdutoTO to = resp.get_return();
			System.out.println(to.getNome());
			System.out.println(to.getDescricao());
			System.out.println(to.getPreco());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
