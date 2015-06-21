package br.ufc.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.RolesDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Secao;
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
	@Autowired
	private SecaoDAO sDAO;

	@RequestMapping("formulario_usuario")
	public String formularioInserir(){
		return "usuarios/formulario_usuario";
	}

	@RequestMapping("inserir_usuario")
	public String inserirUsuario(Usuario usu){
		String novaSenha;
		Role role = new Role();
		role.setId(3);
	
		List<Role> papeis = new ArrayList<Role>();
		
		System.out.println("veio aqui!!!");
		papeis.add(roleDAO.getRole(role));
		
		usu.setRoleList(papeis);
		novaSenha = uDAO.criptografarSenha(usu.getSenha());
		usu.setSenha(novaSenha);
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
	public String verificaLogin(Usuario usu, HttpSession session, Model model){
		System.out.println("Aqui");
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		
		if(uDAO.getUsuario(usu) != null){
			String senha;
			senha = uDAO.criptografarSenha(usu.getSenha());
			if(senha.equals(uDAO.getUsuario(usu).getSenha()) ){
				session.setAttribute("usuario_logado", uDAO.getUsuario(usu));
				//System.out.println("nome >"+usu.getNome());
				//System.out.println("nome >>"+uDAO.getUsuario(usu).getNome());
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
		role.setId(2);
	
		List<Role> papeis = new ArrayList<Role>();
		
		System.out.println("inserindo jornalista");
		papeis.add(roleDAO.getRole(role));
		
		String novaSenha = uDAO.criptografarSenha(usu.getSenha());
		usu.setSenha(novaSenha);
		
		usu.setRoleList(papeis);
		
		this.uDAO.cadastrar(usu);
		return "../../index";
		
	}
}
