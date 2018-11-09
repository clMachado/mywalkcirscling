package br.com.clmDeveloper.mywalkcircling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PrincipalController {
	
	    @GetMapping("/principal")
	    public String principal(Model model) {
	        model.addAttribute("nome", "Cleverson Machado");
	        return "principal";
	    }
	    
	    @GetMapping("/login")
		public String login(){
			return "login";
		}
		
		
		@GetMapping("/login-error")
		public String loginError(Model model){
			model.addAttribute("error_login", true);
			return "login";
		}

}
