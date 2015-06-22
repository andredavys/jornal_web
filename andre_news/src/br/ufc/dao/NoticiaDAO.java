package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Repository
public class NoticiaDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Noticia noticia) {
		this.manager.persist(noticia);
	}

	public void remover(Noticia noticia) {
		Noticia n = this.manager.find(Noticia.class, noticia.getId_noticia());
		this.manager.remove(n);
	}

	public void alterar(Noticia noticia) {
		this.manager.merge(noticia);
	}

	public List<Noticia> listar() {
		String hql = "SELECT n FROM Noticia n";
		return this.manager.createQuery(hql, Noticia.class).getResultList();
	}
	
	public Noticia buscarPorId(Noticia noticia){
		Noticia not = this.manager.find(Noticia.class, noticia.getId_noticia());
		return not;
	}
}
