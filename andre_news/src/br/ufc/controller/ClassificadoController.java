package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.model.Classificado;


@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	ClassificadoDAO cDAO;
	
	@RequestMapping("formulario_classificado")
	public String formularioClassificado(){
		return "classificado/formulario_classificado";
	}
	
	@RequestMapping("cadastrar_classificado")
	public String cadastrarClassificado(Classificado classificado){
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
}
