package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.service.CadastroEstiloService;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;

@Controller
public class EstilosController {

	@Autowired
	private CadastroEstiloService cadastroEstiloService;

	@RequestMapping("/estilos/novo")
	ModelAndView novo(Estilo estilo) {
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}

	@RequestMapping(value = "/estilos/novo", method = RequestMethod.POST)
	ModelAndView cadastro(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return (novo(estilo));
		}
		try {
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return (novo(estilo));
		}

		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso!");
		return new ModelAndView("redirect:/estilos/novo");
	}

	@RequestMapping(value = "/estilos", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody Estilo estilo, BindingResult result) {
		System.out.println("Estilo: " + estilo.getNome());
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage());
		}
		try {
			estilo = cadastroEstiloService.salvar(estilo);
		}
		catch(NomeEstiloJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(estilo);
	}
}
