package br.com.clmDeveloper.mywalkcircling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clmDeveloper.mywalkcircling.resources.PontoServiceImpl;
import br.com.clmDeveloper.mywalkcircling.service.AppService;

@Controller
@RequestMapping("/maps")
public class TesteMapsController {
	
	//@Autowired
	//PontoServiceImpl pontoService;
	
	@Autowired
	AppService appService;
	
	@GetMapping({"/",""})
    public String principal(Model model) {
        model.addAttribute("apiKey", "AIzaSyCM9MWBUGkFZvw2PJIZQ9CNWkm4QZD8RGU");
        model.addAttribute("nome", "Cleverson machado");
        
        Integer id = 52;
        
        model.addAttribute("pontos", appService.buscaPontos(id));
        
        
        return "testeMaps";
    }

}
