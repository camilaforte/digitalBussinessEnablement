package br.com.fiap.dbe.jpa.dao;

import java.util.List;

import br.com.fiap.dbe.jpa.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	List<T> listar();
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	
}



