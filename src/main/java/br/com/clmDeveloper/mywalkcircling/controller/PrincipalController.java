package br.com.clmDeveloper.mywalkcircling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PrincipalController {
	
	    @GetMapping("/principal")
	    public String greeting(Model model) {
	        model.addAttribute("nome", "Cleverson Machado");
	        return "principal";
	    }

}
