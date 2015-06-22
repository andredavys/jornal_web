package br.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;
import java.util.List;

@Repository
public class ComentarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Comentario comment){
		this.manager.persist(comment);
	}

	public void remover(Comentario comment){
		Comentario c = this.manager.find(Comentario.class, comment);
		this.manager.remove(c);
	}
	
	public List<Comentario> listar(){
		String hql = "SELECT c FROM Comentario c";
		return this.manager.createQuery(hql, Comentario.class).getResultList();
	}
	
	public List<Comentario> listarPorNoticia(Long id_noticia){
		String hql = "SELECT c FROM Comentario c WHERE noticia='"+id_noticia+"'";
		return this.manager.createQuery(hql, Comentario.class).getResultList();
	}
}
