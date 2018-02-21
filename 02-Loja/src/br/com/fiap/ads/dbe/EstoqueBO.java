package br.com.fiap.ads.dbe;

import br.com.fiap.ads.dbe.bean.ProdutoTO;

public class EstoqueBO {

	public ProdutoTO consultarProduto(int codigo) {
		ProdutoTO to = null;
		
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401, "Camiseta masculina", 40, "Camiseta branca");
			break;
		case 402:
			to = new ProdutoTO(401, "Camiseta masculina" , 50, "Camiseta rosa");
			break;
		default:
			break;
		}
		return to;
	}
}
