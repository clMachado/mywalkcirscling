package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
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
	@Transactional
	@RequestMapping("/addPonto")
	@PostMapping(produces="application/json")
	public Ponto CriarPonto(@RequestBody @Valid Ponto ponto) {
		return pontoRepository.save(ponto);
	}
	
	@Override
	@Transactional
	@RequestMapping("/addPontos")
	@PostMapping(produces="application/json")
	public String CriarPontos(@RequestBody @Valid ListPontos pontos) {

		try {
			for (Ponto ponto : pontos.getPontos()) {
				CriarPonto(ponto);			
			}		
			return "sucesso";
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		
	}
	
	
	@Override
	@Transactional
	@PostMapping(produces="application/json")
	@RequestMapping("/getPontos")
	public List<Ponto> findPontosByRota(@RequestBody @Valid Rota rota) {	
		
		//List<Ponto> lp = 
				return pontoRepository.findPontobyRota(rota);
//		if (lp == null)
//			lp = new ArrayList();
//		return lp;
	}

}
