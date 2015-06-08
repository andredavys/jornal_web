package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {

	@Autowired
	private SecaoDAO sDAO;
	
	@RequestMapping("cadastrar_secao")
	public String cadastrarSecao(Secao secao){
		this.sDAO.cadastrar(secao);
		return "secao/principal";
	}
	
	@RequestMapping("formulario_secao")
	public String formularioSecao(){
		return "secao/formulario_secao";
	}
}
