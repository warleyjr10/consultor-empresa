package com.warley.consultor.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.warley.consultor.model.Empresa;
import com.warley.consultor.repository.*;

@Controller
@RequestMapping
public class EmpresaController {
		
	@Autowired
	private EmpresaRepository dados;
	
	@GetMapping("/listar")
	public ModelAndView listar() { 
		ModelAndView modelAndView = new ModelAndView("index");	
		modelAndView.addObject("empresas", dados.findAll());
		modelAndView.addObject("empresa", new Empresa());
		
		return modelAndView;
	}
	
	
	
	@GetMapping("/novo")
	public String Cadastrar(Model model) {
		model.addAttribute("empresas", new Empresa());
		return "form";
	}
	
	@PostMapping("/save")
	public String salvar(Empresa empresa) {
		this.dados.save(empresa);
		
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Empresa> editar = dados.findById(id);
		model.addAttribute("empresas", editar);
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(Model model, @PathVariable Long id) {
		dados.deleteById(id);
		return "redirect:/listar";
	}
	
}