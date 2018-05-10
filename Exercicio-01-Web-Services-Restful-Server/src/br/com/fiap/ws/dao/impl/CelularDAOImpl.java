package br.com.fiap.ws.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.CelularDAO;
import br.com.fiap.ws.entity.Celular;

public class CelularDAOImpl extends GenericDAOImpl<Celular, Integer> implements CelularDAO{

	public CelularDAOImpl(EntityManager em) {
		super(em);
		
	}

}
