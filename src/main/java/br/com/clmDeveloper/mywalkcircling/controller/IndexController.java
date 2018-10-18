package br.com.clmDeveloper.mywalkcircling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	    @GetMapping({"","/", "/index"})
	    public String greeting(Model model) {
	        model.addAttribute("name", "Cleverson Machado");
	        return "index";
	    }

}
