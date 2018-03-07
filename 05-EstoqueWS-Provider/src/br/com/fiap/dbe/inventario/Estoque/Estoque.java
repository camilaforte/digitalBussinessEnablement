package br.com.fiap.dbe.inventario.Estoque;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

public class Estoque {
	
	public List<ProdutoTO> listar(){
		List<ProdutoTO> lista= new ArrayList<>();
		lista.add(new ProdutoTO(402, "Camiseta", "Masculina", 50, 22.4));
		lista.add(new ProdutoTO(401, "Camiseta", "Feminina", 45, 12.5));
		return lista;
	}
	
	
	public ProdutoTO buscarProduto(String codigo) throws AxisFault {
		
		ProdutoTO to = null;
		switch (codigo) {
		case "401":
			to = new ProdutoTO(401, "Camiseta masculina", "Camiseta branca", 40, 4.5);
			break;
		case "402":
			to = new ProdutoTO(402, "Camiseta feminina", "camiselsnd", 40, 7.5);
			break;
		default:
			throw new AxisFault("Produto não encontrado!");
		}
		return to;
	
	}
	
}
