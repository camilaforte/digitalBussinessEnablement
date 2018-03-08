package br.com.fiap.ads.dbe.aula05.exercicio.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.dbe.inventario.estoque.EstoqueStub;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.BuscarProduto;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.BuscarProdutoResponse;
import br.com.fiap.dbe.inventario.estoque.EstoqueStub.ProdutoTO;

public class ChamaWS {

	private EstoqueStub stub;
	
	public ChamaWS() throws AxisFault {
		stub = new EstoqueStub();
	}
	
	public ProdutoTO buscarProduto(int codigo) throws RemoteException {
		
		BuscarProduto parametros = new BuscarProduto();
		parametros.setCodigo(String.valueOf(codigo));
		
		
		BuscarProdutoResponse rest = stub.buscarProduto(parametros);
		
		return rest.get_return();
	}
	
	
}
