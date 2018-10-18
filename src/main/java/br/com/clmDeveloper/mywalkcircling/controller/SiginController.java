package br.com.clmDeveloper.mywalkcircling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiginController {
	
	 @GetMapping("/sigin")
	    public String principal(Model model) {
	        model.addAttribute("nome", "Cleverson Machado");
	        return "sigin";
	    }


}
