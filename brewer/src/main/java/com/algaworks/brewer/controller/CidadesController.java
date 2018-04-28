package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cidade;

@Controller
public class CidadesController {

	@RequestMapping("/cidades/nova")
	String nova(Cidade cidade) {
		return "cidade/CadastroCidade";
	}
	
	@RequestMapping(value = "/cidades/novo",method = RequestMethod.POST)
	String cadastro(@Valid Cidade cidade, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return nova(cidade);
		}
		
		//salvar no banco
		
		//ele cria uma sessão provisária e mostra a msg antes de redirecionar
		//redireciona pra uma url, e não para nome da view
		attributes.addFlashAttribute("mensagem","Cidade salva com sucesso!");
		return "redirect:/cidades/nova";
			
	}
}
