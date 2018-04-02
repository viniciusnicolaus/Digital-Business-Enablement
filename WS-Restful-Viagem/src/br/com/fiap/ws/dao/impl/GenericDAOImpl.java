package br.com.fiap.ws.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.GenericDAO;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.exception.RegistroNaoEncontradoException;

public abstract class GenericDAOImpl <Tabela, Chave>
					implements GenericDAO<Tabela, Chave>{

	private EntityManager em;
	
	private Class<Tabela> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<Tabela>)
			((ParameterizedType)
				getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(Tabela tabela) {
		em.persist(tabela);
	}

	@Override
	public void atualizar(Tabela tabela) {
		em.merge(tabela);
	}

	@Override
	public void excluir(Chave codigo) throws RegistroNaoEncontradoException {
		Tabela t  = buscar(codigo);
		if (t == null) {
			throw new RegistroNaoEncontradoException("Registro n�o encontrado");
		}
		em.remove(t);
	}

	@Override
	public Tabela buscar(Chave codigo) {
		return em.find(clazz, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
	}
	
	@Override
	public List<Tabela> listar(){
		return em.createQuery("from " + clazz.getName(),
				clazz).getResultList();
	}

}