package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Usuario usu) {
		this.manager.persist(usu);
	}

	public void remover(Usuario usu) {
		Usuario u = this.manager.find(Usuario.class, usu.getLogin());
		this.manager.remove(u);
	}

	public void alterar(Usuario usu) {
		this.manager.merge(usu);
	}

	public List<Usuario> listar() {
		String hql = "SELECT u FROM Usuario u";
		return this.manager.createQuery(hql, Usuario.class).getResultList();
	}

	public Usuario getUsuario(Usuario usu){
		String hql = "SELECT u FROM Usuario u WHERE u.login='" + usu.getLogin()+"'";
		List<?> res = this.manager.createQuery(hql).getResultList();
		if(!res.isEmpty())
			return (Usuario) this.manager.createQuery(hql).getResultList().get(0);
		return null;
	}
}
