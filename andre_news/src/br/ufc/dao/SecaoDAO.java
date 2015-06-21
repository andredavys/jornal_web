package br.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Repository
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Secao secao){
		this.manager.persist(secao);
	}
	
	public void remover(Secao secao){
		Secao section = this.manager.find(Secao.class, secao.getIdSecao());
		this.manager.remove(section);
	}
	
	public List<Secao> listar(){
		String hql = "SELECT s FROM Secao s";
		return this.manager.createQuery(hql, Secao.class).getResultList();
	}
	public Secao buscarPorId(Secao secao){
		Secao s = this.manager.find(Secao.class, secao.getIdSecao());
		return s;
	}
	public Secao buscarPorTitulo(Secao secao){
		String hql = "SELECT s FROM Secao s WHERE s.titulo='" +secao.getTitulo()+"'";
		List<?> res = this.manager.createQuery(hql).getResultList();
		if(!res.isEmpty())
			return (Secao) this.manager.createQuery(hql).getResultList().get(0);
		return null;	
	}
}

