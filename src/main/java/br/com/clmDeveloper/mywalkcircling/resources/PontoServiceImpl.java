package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/reposit/pontos")
public class PontoServiceImpl implements PontoService{

	@Autowired
	private PontoRepository pontoRepository;
	
	@Override
	@RequestMapping("/addPonto")
	@PostMapping(produces="application/json")
	public Ponto CriarPonto(@RequestBody @Valid Ponto ponto) {
		return pontoRepository.save(ponto);
	}
	
	@Override
	@RequestMapping("/addPontos")
	@PostMapping(produces="application/json")
	public boolean CriarPontos(@RequestBody @Valid List<Ponto> pontos) {
		try {
			for (Ponto ponto : pontos) {
				CriarPonto(ponto);			
			}		
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	@GetMapping(produces="application/json")
	@RequestMapping("/getPontos")
	public List<Ponto> findPontosByRota(Rota rota) {	
		
		List<Ponto> lp = pontoRepository.findPontobyRota(rota);
		if (lp == null)
			lp = new ArrayList();
		return lp;
	}

}
