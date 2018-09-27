package br.com.fiap.spring05mvcjpa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.spring05mvcjpa.dao.ConvidadoDAO;
import br.com.fiap.spring05mvcjpa.model.Convidado;

@Repository
public class ConvidadoDAOImpl extends GenericDAOImpl<Convidado, Integer> implements ConvidadoDAO {

	@Override
	public void confirmar(int id) {
		Convidado con = pesquisar(id);
		con.setConfirmado(true);
		atualizar(con);
		
		
	}

	@Override
	public List<Convidado> pesquisarPor(String nome) {

		return em.createQuery("FROM Convidade WHERE UPPER(nome) LIKE UPPER (:n)", Convidado.class)
		.setParameter("n", "%"+nome+"%")
		.getResultList();
	}

}


