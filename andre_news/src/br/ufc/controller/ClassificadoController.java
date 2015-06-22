package br.ufc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Usuario;


@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	ClassificadoDAO cDAO;
	@Autowired
	UsuarioDAO uDAO;
	
	@RequestMapping("formulario_classificado")
	public String formularioClassificado(){
		return "classificado/formulario_classificado";
	}
	
	@RequestMapping("cadastrar_classificado")
	public String cadastrarClassificado(Classificado classificado){
		/*Usuario usuario = new Usuario();
		Usuario usu = new Usuario();
		usuario.setId(id_usuario);
		usu = uDAO.buscarPorId(usuario);
		classificado.setUsuario(usu);
		classificado.setDataOferta(new Date());*/
		this.cDAO.cadastrar(classificado);
		return "redirect:listar_classificados";
	}
	
	@RequestMapping("listar_classificados")
	public String listarClassificados(Model model){
		System.out.println("chegou aqui");
		List<Classificado> classificados = this.cDAO.listar();
		model.addAttribute("classificados", classificados);
		
		System.out.println("model concluido");
		return "classificado/visualizar_classificados";
	}
	@RequestMapping("inserir_oferta")
	public String inserirOferta(Model model, Long id_classificado,HttpSession session){
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario_logado");
		Classificado classificado = new Classificado();
		Classificado clas = new Classificado();
		classificado.setId(id_classificado);
		clas = cDAO.buscarPorId(classificado);
		model.addAttribute("classificado", clas);
		if(usuarioLogado != null && usuarioLogado.is("Leitor")){
			return "classificado/inserir_oferta";
		}else
			return "redirect:realiza_login";	
	}
	@RequestMapping("validar_oferta")
	public String validarOferta(Long id_usuario, Float oferta, Long id_classificado){
		System.out.println("\n\n\n\nTA NO VALIDAR OFERTA >>>>>> \n");
		Classificado clas = new Classificado();
		System.out.println("id do classificado"+ id_classificado);
		clas.setId(id_classificado);
		Classificado classificado = cDAO.buscarPorId(clas);
		classificado.setDataOferta(new Date());
		
		Usuario usuario = new Usuario();
		Usuario usu = new Usuario();
		usuario.setId(id_usuario);
		usu = uDAO.buscarPorId(usuario);
		
		if(oferta > classificado.getPreco() && oferta > classificado.getMelhor_oferta()){
			classificado.setMelhorOferta(oferta);
			classificado.setUsuario(usu);
			cDAO.alterar(classificado);	
		}
		return "secao/principal";
	}
}
