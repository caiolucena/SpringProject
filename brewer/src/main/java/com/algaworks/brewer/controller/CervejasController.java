package com.algaworks.brewer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	//SE for get chama esse
	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	//SE for post, chama esse
	@RequestMapping(value = "/cervejas/novo",method = RequestMethod.POST)
	public String  cadastrar(Cerveja cerveja) { //ela pega o nome lá do form
		System.out.println("Cadastrar ="+cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}
}
