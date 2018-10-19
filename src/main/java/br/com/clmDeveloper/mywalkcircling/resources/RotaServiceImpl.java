package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

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

	@Override
	@RequestMapping("/addRota")
	@PostMapping(produces="application/json")
	public Rota CriarRota(@RequestBody @Valid Rota rota) {
		return rotaRepository.save(rota);
	}
	
	@Override
	@RequestMapping("/addRotas")
	@PostMapping(produces="application/json")
	public String CriarRotas(@RequestBody @Valid ListRotas rotas) {

		try {
			for (Rota rota : rotas.getRotas()) {
				CriarRota(rota);			
			}		
			return "sucesso";
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		//return false;
	}

	@Override
	@GetMapping(produces="application/json")
	@RequestMapping("/{email}/getRotas")
	public List<Rota> findAllRotas(@PathVariable String email) {
		return rotaRepository.findAllRotas(email);
	}

}
