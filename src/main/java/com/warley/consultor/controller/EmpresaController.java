package com.warley.consultor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/listarAntiga")
	public ModelAndView pesquisarEmpresaMaisOld() {
		ModelAndView modelAndView = new ModelAndView("antiga");
		modelAndView.addObject("empresas", dados.pesquisarEmpresaMaisAntiga());
		modelAndView.addObject("empresa", new Empresa());
		return modelAndView;
	}

	@GetMapping("/listarNumFuncionarios")
	public ModelAndView pesquisarRegiaoNumFuncionarios() {
		ModelAndView modelAndView = new ModelAndView("numFuncionarios");
		modelAndView.addObject("empresas", dados.pesquisarRegiaoNumFuncionarios());
		modelAndView.addObject("empresa", new Empresa());
		return modelAndView;
	}
	
	@GetMapping("/listarNumeroSetorAtuacao")
	public ModelAndView pesquisarNumEmpresasSetor() {
		ModelAndView modelAndView = new ModelAndView("numeroSetor");
		modelAndView.addObject("empresas", dados.pesquisarNumEmpresasSetor());
		modelAndView.addObject("empresa", new Empresa());
		return modelAndView;
	}
	
	@GetMapping("/listarSetorAtuacao")
	public ModelAndView pesquisarRegiaoMaisIndustrial() {
		ModelAndView modelAndView = new ModelAndView("setorAtuacao");
		modelAndView.addObject("empresas", dados.pesquisarRegiaoMaisIndustrial());
		modelAndView.addObject("empresa", new Empresa());

		return modelAndView;
	}
	
	@GetMapping("/novo")
	public String Cadastrar(Model model) {
		model.addAttribute("empresas", new Empresa());
		return "form";
	}

	@PostMapping("/save")
	public String salvar(@ModelAttribute("empresas") Empresa empresa) {
		dados.save(empresa);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView pesquisarEditEmpresa(@PathVariable(value = "id") Long id) {
		ModelAndView editarView = new ModelAndView("form_editar");
		Empresa empresa = dados.findEmpresaById(id);
		editarView.addObject("empresas", empresa);
		
		return editarView;
	}
	
	@GetMapping("/delete/{id}")
	public String deletar(Model model, @PathVariable Long id) {
		dados.deleteById(id);
		return "redirect:/listar";
	}

}
