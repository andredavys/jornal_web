package br.ufc.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.RolesDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Usuario;
import br.ufc.model.Role;

import java.util.List;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO uDAO;
	@Autowired
	private RolesDAO roleDAO;

	@RequestMapping("formulario_usuario")
	public String formularioInserir(){
		return "usuarios/formulario_usuario";
	}

	@RequestMapping("inserir_usuario")
	public String inserirUsuario(Usuario usu){
		Role role = new Role();
		role.setId(1);
	
		List<Role> papeis = new ArrayList<Role>();
		
		System.out.println("veio aqui!!!");
		papeis.add(roleDAO.getRole(role));
		
		usu.setRoleList(papeis);
		//session.setAttribute("papeis", papeis);
		
		this.uDAO.cadastrar(usu);
		return "../../index";
	}
	
	@RequestMapping("realiza_login")
	public String realizaLogin(){
		System.out.println("logaaaaa");
		return "realizar_login";
	}
	
	@RequestMapping("verifica_login")
	public String verificaLogin(Usuario usu, HttpSession session){
		System.out.println("Aqui");
		if(uDAO.getUsuario(usu) != null){
			if(usu.getLogin().equals(uDAO.getUsuario(usu).getLogin()) 
					&& usu.getSenha().equals(uDAO.getUsuario(usu).getSenha()) ){
				session.setAttribute("usuario_logado", uDAO.getUsuario(usu));

				System.out.println("nome >"+usu.getNome());
				System.out.println("nome >>"+uDAO.getUsuario(usu).getNome());
				return "secao/principal";
			}
			else{
				System.out.println("veio aqui");

				//Retornar mensagem de erro
				return "redirect:realiza_login";
			}
		}
		else{
			System.out.println("veio aqui");

			//Retornar mensagem de erro
			return "redirect:realiza_login";
		}	
	}
	
	@RequestMapping("formulario_jornalista")
	public String formularioJornalista(){
		return "usuarios/formulario_jornalista";
	}
	
	
	@RequestMapping("cadastrar_jornalista")
	public String cadastrarJornalista(Usuario usu){
		Role role = new Role();
		role.setId(3);
	
		List<Role> papeis = new ArrayList<Role>();
		
		System.out.println("inserindo jornalista");
		papeis.add(roleDAO.getRole(role));
		
		usu.setRoleList(papeis);
		
		this.uDAO.cadastrar(usu);
		return "../../index";
		
	}
}
