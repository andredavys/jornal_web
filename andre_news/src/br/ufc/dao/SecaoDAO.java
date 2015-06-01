package br.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;

@Repository
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Secao secao){
		this.manager.persist(secao);
	}
	
	public void remover(Secao secao){
		Secao section = this.manager.find(Secao.class, secao.getId());
		this.manager.remove(section);
	}
	
	public List<Secao> listar(){
		String hql = "SELECT s FROM Secao s";
		return this.manager.createQuery(hql, Secao.class).getResultList();
	}
}
