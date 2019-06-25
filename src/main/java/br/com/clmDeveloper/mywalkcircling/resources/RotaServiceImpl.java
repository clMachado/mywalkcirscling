package br.com.clmDeveloper.mywalkcircling.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;

@Service
@RestController
@RequestMapping("/reposit/rota")
public class RotaServiceImpl implements RotaService{
	
	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private PontoRepository pontoRepository;
	/*
	private ListRotas listRotas;
	
	
	
	

	@Override
	@RequestMapping("/addRota")
	@PostMapping(produces="application/json")
	public ListRotas CriarRota(@RequestBody @Valid Rota rota) {
		
		listRotas = new ListRotas();
		listRotas.addRota(rotaRepository.save(rota));
		
		return listRotas;
	}
	
	
	
	
	@Override
	@RequestMapping("/addRotas")
	@PostMapping(produces="application/json")
	public ListRotas CriarRotas(@RequestBody @Valid ListRotas rotas) {
		listRotas = new ListRotas(); 
		try {
			for (Rota rota : rotas.getRotas()) {
				listRotas.addRota(rotaRepository.save(rota));
			}		
			
			listRotas.setMsg("sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
			listRotas.setMsg(e.toString());
		}
		
		return listRotas;
	}

	
	
	
	@Override
	@GetMapping(produces="application/json")
	@RequestMapping({"/getRotas/{email}", "/getRotas"})
	public ListRotas findAllRotas(@PathVariable String email) {
		listRotas = new ListRotas();
		if(!email.trim().equals(""))
		   listRotas.setRotas(rotaRepository.findAllRotas(email));
		else
		   listRotas.setRotas(rotaRepository.findAll());	
		
		if (listRotas.getRotas().toString() == "[]")
			listRotas.setMsg("Nenhuma Rota vinculada ao email " + email + ".");
		
		return listRotas;
	}
	
	
	
	
	
	@Override
	@GetMapping(produces="application/json")
	@RequestMapping("/{email}/getRotasCompleto")
	public ListRotas findAllRotasPontos(@PathVariable String email) {
		
		listRotas = new ListRotas();
		
		if(email.trim().equals("")) {
		   listRotas.setMsg("ERRO: Um Email de usuario deve ser informado!!");
		   return listRotas;
		}		
				
		
		listRotas.setRotas(rotaRepository.findAllRotas(email));
		
		if (listRotas.getRotas().toString() == "[]")
			listRotas.setMsg("Nenhuma Rota vinculada ao email " + email + ".");
		else {
		    // carrego os pontos de cada Rota
			for(Rota rota: listRotas.getRotas()) {
				rota.setPontos(pontoRepository.findPontobyRota(rota));
			}
		}
				
		return listRotas;
	}
	
	
	
	@Override
	@GetMapping(produces="application/json")
	@RequestMapping("/getRotasCompleto/{id}")
	public ListRotas findAllRotaPontos(@PathVariable Long id) {
		listRotas = new ListRotas();

		Rota rota = rotaRepository.findByID(id);

		if (rota != null) {
		   rota.setPontos(pontoRepository.findPontobyRota(rota));
		   listRotas.addRota(rota);	
		}
		else
			listRotas.setMsg("Nenhuma Rota localizada. " + " (" + id + ")");
		
		return listRotas;
	}
	*/

}
