package br.com.fiap.ads.dbe;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.ads.dbe.bean.ProdutoTO;

public class EstoqueBO {
	
	private static final Logger log = LoggerFactory.getLogger(EstoqueBO.class);			//criando o objeto log

	public ProdutoTO consultarProduto(int codigo) {
		
		ProdutoTO to = null;
		log.debug("Pesquisando um produto");											//log 
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
