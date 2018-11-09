package br.com.clmDeveloper.mywalkcircling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clmDeveloper.mywalkcircling.resources.PontoServiceImpl;

@Controller
@RequestMapping("/maps")
public class TesteMapsController {
	
	@Autowired
	PontoServiceImpl pontoService;
	
	@GetMapping({"/",""})
    public String principal(Model model) {
        model.addAttribute("apiKey", "AIzaSyDOuUquy-tslhCtW_NDULMvtkXEXGhptNw");
        model.addAttribute("nome", "Cleverson machado");
        
        model.addAttribute("pontos",pontoService.findPontosByRota(52L));
        
        
        return "testeMaps";
    }

}
