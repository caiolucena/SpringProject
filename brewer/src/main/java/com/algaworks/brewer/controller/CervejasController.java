package com.algaworks.brewer.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.Origem;
import com.algaworks.brewer.model.Sabor;
import com.algaworks.brewer.repository.Estilos;

@Controller
public class CervejasController {
	
	@Autowired
	private Estilos estilos;
	
	//SE for get chama esse
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores",Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	//SE for post, chama esse
	@RequestMapping(value = "/cervejas/novo",method = RequestMethod.POST)
	public ModelAndView  cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model,
			RedirectAttributes attributes) { //ela pega o nome lá do form
//		if(result.hasErrors()) {
//			return novo(cerveja);
//		}
		
		//salvar no banco
		
		//ele cria uma sessão provisária e mostra a msg antes de redirecionar
		//redireciona pra uma url, e não para nome da view
		attributes.addFlashAttribute("mensagem","Cerveja salva com sucesso!");
		System.out.println(">>>SKU: "+ cerveja.getSku());
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
}
