package com.algaworks.brewer.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	//SE for get chama esse
	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";
	}
	
	//SE for post, chama esse
	@RequestMapping(value = "/cervejas/novo",method = RequestMethod.POST)
	public String  cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model,
			RedirectAttributes attributes) { //ela pega o nome lá do form
		if(result.hasErrors()) {
			return novo(cerveja);
		}
		
		//salvar no banco
		
		//ele cria uma sessão provisária e mostra a msg antes de redirecionar
		//redireciona pra uma url, e não para nome da view
		attributes.addFlashAttribute("mensagem","Cerveja salva com sucesso!");
		return "redirect:/cervejas/novo";
	}
	
	@RequestMapping("/cervejas/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}
}
