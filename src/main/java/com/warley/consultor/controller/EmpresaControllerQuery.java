package com.warley.consultor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.warley.consultor.model.Empresa;
import com.warley.consultor.model.EmpresaQuery;
import com.warley.consultor.repository.EmpresaRepositoryQuery;

@Controller
@RequestMapping
public class EmpresaControllerQuery {
	
	@Autowired
	private EmpresaRepositoryQuery dadosQuery;
	
	@GetMapping("/listarNumTotalFuncionarios")
	public ModelAndView pesquisarNumTotalFuncionarios() {
		ModelAndView modelAndView = new ModelAndView("numTotalFuncionarios");
		modelAndView.addObject("empresasQuery", dadosQuery.pesquisarNumTotalFuncionarios());
		modelAndView.addObject("empresaQuery", new EmpresaQuery());
		return modelAndView;
	}

	
	@GetMapping("/listarTotalFuncionarios")
	public ModelAndView listarNumTotalFuncionarios() {
		ModelAndView modelAndView = new ModelAndView("listarNumTotalFuncionarios");
		modelAndView.addObject("empresasQuery", dadosQuery.listarNumTotalFuncionarios());
		modelAndView.addObject("empresaQuery", new EmpresaQuery());
		return modelAndView;
	}
}
