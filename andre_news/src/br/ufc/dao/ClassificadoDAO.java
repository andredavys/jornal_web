package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Classificado cla){
		this.manager.persist(cla);
	}
	
	public void remover(Classificado cla){
		Classificado c = this.manager.find(Classificado.class, cla);
		this.manager.remove(c);
	}
	
	public void alterar(Classificado cla){
		this.manager.merge(cla);
	}
	
	public List<Classificado> listar(){
		String hql = "SELECT c FROM Classificado c";
		return this.manager.createQuery(hql, Classificado.class).getResultList();
	}
}
