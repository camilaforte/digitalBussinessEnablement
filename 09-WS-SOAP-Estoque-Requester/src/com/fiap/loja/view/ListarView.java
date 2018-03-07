package com.fiap.loja.view;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;

import br.com.fiap.dbe.inventario.estoque.EstoqueStub;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.Listar;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.ListarResponse;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.ProdutoTO;

public class ListarView {

	public static void main(String[] args) {

		try {
			EstoqueStub stub = new EstoqueStub();
			Listar arg = new Listar();
			ListarResponse resp = stub.listar(arg);
			List<ProdutoTO> listagem = Arrays.asList(resp.get_return());
			
			for(ProdutoTO produtoTO : listagem) {
				System.out.println(produtoTO.getNome());
				System.out.println(produtoTO.getDescricao());
				System.out.println(produtoTO.getPreco());
				System.out.println("********************");
			}
			
		} catch (AxisFault e) {

			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	}
}
