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
import br.com.clmDeveloper.mywalkcircling.classes.ListRotas;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;

@Service
@RestController
@RequestMapping("/reposit/rota")
public class RotaServiceImpl implements RotaService{
	
	@Autowired
	private RotaRepository rotaRepository;
	
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
	@RequestMapping("/{email}/getRotas")
	public ListRotas findAllRotas(@PathVariable String email) {
		listRotas = new ListRotas();
		listRotas.setRotas(rotaRepository.findAllRotas(email));
		
		if (listRotas.getRotas().toString() == "[]")
			listRotas.setMsg("Nenhuma Rota vinculada ao email " + email + ".");
		
		return listRotas;
	}

}
