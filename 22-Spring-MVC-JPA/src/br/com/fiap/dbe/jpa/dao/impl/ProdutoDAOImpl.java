package br.com.fiap.dbe.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.dbe.jpa.dao.ProdutoDAO;
import br.com.fiap.dbe.jpa.model.Produto;

@Repository
public class ProdutoDAOImpl extends GenericDAOImpl<Produto, Integer> implements ProdutoDAO{

}
