package br.com.clmDeveloper.mywalkcircling.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.ListRotas;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;
import br.com.clmDeveloper.mywalkcircling.resources.RotaService;


@Controller
@RequestMapping("/rota")
public class RotasController {
	
	private static final String API_KEY = "AIzaSyDOuUquy-tslhCtW_NDULMvtkXEXGhptNw";

	@Autowired
	RotaService rotaService;
	@Autowired
	RotaRepository rotaRepositorio;
	@Autowired 
	PontoRepository pontoRepositorio;

	
	@GetMapping({"/",""})
    public String principal(Model model, RedirectAttributes redirect) {
        model.addAttribute("nome", "Cleverson machado");
        
         ListRotas lista = rotaService.findAllRotas("mxd.maxado@gmail.com");
         
         if("".equals(lista.getMsg()) ||
        	lista.getMsg() == null	 ){
            List<Rota> rotas = lista.getRotas();
        
            model.addAttribute("rotas",rotas);
         }
         else redirect.addFlashAttribute("msg", lista.getMsg());
        
        return "rota/rotas";
    }
	
	@GetMapping("/visualizar/{ID}")
	public String visualizar(@PathVariable Long ID,  Model model, RedirectAttributes redirect){
		
		//@RequestParam String user,
		ListRotas lista = rotaService.findAllRotaPontos(ID);
		
		if("".equals(lista.getMsg()) ||
	        	lista.getMsg() == null	 ){
            List<Ponto> pontos = lista.getRotas().get(0).getPontos();
            
            ListPontos lp = new ListPontos();
            lp.setPontos(pontos);

            //Gson gson = new Gson();
           // String listPontos = gson.toJson(pontos);
            
            
            
            model.addAttribute("apiKey", API_KEY);
            model.addAttribute("idRota", ID);
          //  model.addAttribute("pontos",pontos);
            model.addAttribute("nomeRota",lista.getRotas().get(0).getDescricao());
         }
         else {
        	 redirect.addFlashAttribute("msg", lista.getMsg());
        	 redirect.addFlashAttribute("erro", true);
        	 return "rota/rotas";
         }
		
		return "rota/pontos";
	}
	
	
	
	@GetMapping("/remover/{ID}")
	public String remover(@PathVariable Long ID, Model model, RedirectAttributes redirect){
		
		/*ListRotas lista = rotaService.findAllRotaPontos(ID);
		
		if("".equals(lista.getMsg()) ||
	        	lista.getMsg() == null	 ){
            List<Ponto> pontos = lista.getRotas().get(0).getPontos();
            
            for(Ponto ponto : pontos){		
		      pontoRepositorio.delete(ponto);
            }
		}

		rotaRepositorio.deleteById(ID);
		*/
		redirect.addFlashAttribute("msg", "Rota excluida com sucesso!!");
		redirect.addFlashAttribute("erro", false);
		return "redirect:/rota/";
	}
	
	
}
