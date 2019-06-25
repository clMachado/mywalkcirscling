package br.com.clmDeveloper.mywalkcircling.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Resposta;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.classes.RotaAdapter;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;
import br.com.clmDeveloper.mywalkcircling.resources.RotaService;
import br.com.clmDeveloper.mywalkcircling.service.AppService;


@Controller
@RequestMapping("/rota")
public class RotasController {
	
	private static final String API_KEY = "AIzaSyCM9MWBUGkFZvw2PJIZQ9CNWkm4QZD8RGU";

	@Autowired
	RotaService rotaService;
	@Autowired
	RotaRepository rotaRepositorio;
	@Autowired 
	PontoRepository pontoRepositorio;

	@Autowired
	AppService appService;
	
	@GetMapping({"/",""})
    public String principal(Model model, RedirectAttributes redirect) {
        model.addAttribute("nome", "Cleverson machado");
        
         Resposta resp = appService.listar("");
         List<Rota> lista = new ArrayList<>();
         
         for(RotaAdapter adp : resp.getRotas()) {
        	 lista.add(adp.getRota());
         }

         if(lista.size() > 0)
            model.addAttribute("rotas",lista);
         else 
        	redirect.addFlashAttribute("msg", resp.getMsgObs());
        
        return "rota/rotas";
    }
	
	@GetMapping("/visualizar/{ID}")
	public String visualizar(@PathVariable Integer ID,  Model model, RedirectAttributes redirect){
		
		Rota rota = null;
		
		try {
			rota = appService.buscaRota(ID);
				
			if(rota != null){
	            List<Ponto> pontos = appService.buscaPontos(ID);
	
	            model.addAttribute("apiKey", API_KEY);
	            model.addAttribute("idRota", ID);
	            model.addAttribute("nomeRota",rota.getDescricao());
	         }
	         else {
	        	 redirect.addFlashAttribute("msg", "Nenhuma Rota localizada!!");
	        	 redirect.addFlashAttribute("erro", true);
	        	 return "rota/rotas";
	         }		
			return "rota/pontos";
		
		}catch (Exception e) {
			System.out.println("ERRO AQUIIII");
			e.printStackTrace();
			
			redirect.addFlashAttribute("msg", "ERRO AO CARREGAR ROTA!!");
       	 	redirect.addFlashAttribute("erro", true);
       	 	return "rota/rotas";
			
			
			
		}
		
		
		
	}
	
	@GetMapping("/remover/{ID}")
	public String remover(@PathVariable Integer ID, Model model, RedirectAttributes redirect){
		
		try {
		   rotaRepositorio.deleteById(ID);
		   pontoRepositorio.deleteById_Rota(ID);
		   
		   redirect.addFlashAttribute("msg", "Rota excluida com sucesso!!");
		   redirect.addFlashAttribute("erro", false);
		}catch (Exception e) {
			redirect.addFlashAttribute("msg", "Erro ao remover Rota.");
			redirect.addFlashAttribute("erro", true);
			e.printStackTrace();
		}

		return "redirect:/rota/";
	}
	
	
}
