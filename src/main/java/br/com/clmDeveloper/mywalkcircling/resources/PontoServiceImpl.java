package br.com.clmDeveloper.mywalkcircling.resources;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;
import br.com.clmDeveloper.mywalkcircling.service.AppService;

import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/reposit/web/pontos") // request = ENTRADA  response = RESPOSTA
public class PontoServiceImpl implements PontoService{

	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	AppService appService;
	
	/*
	private ListPontos listPontos = null;
	
	@Override
	@Transactional
	@RequestMapping("/addPonto")
	@PostMapping(produces="application/json")
	public ListPontos CriarPonto(@RequestBody @Valid Ponto ponto) {
		listPontos = new ListPontos();
		
		listPontos.addPonto(pontoRepository.save(ponto));		
		return listPontos;
	}
	
	@Override
	@Transactional
	@RequestMapping("/addPontos")
	@PostMapping(produces="application/json")
	public ListPontos CriarPontos(@RequestBody @Valid ListPontos pontos) {

		listPontos = new ListPontos();
		
		try {
			for (Ponto ponto : pontos.getPontos()) {
				listPontos.addPonto(pontoRepository.save(ponto));
			}		
			listPontos.setMsg("sucesso"); 
			
		} catch (Exception e) {
			e.printStackTrace();
			listPontos.setMsg(e.toString());
		}	
		
		return listPontos;
	}
	*/
	// ROTINA ABAIXO ESTA RETORNANDO JSON EM LOOP POR ISSO ESTA COMENTADA (referencia cruzada rota-ponto )
	
	@Override
	@GetMapping(produces="application/json")
	@RequestMapping("/getPontos/{id_rota}")
	public List<Ponto> findPontosByRota(@PathVariable Integer id_rota) {	
		
		System.out.println("veio buscar os pontos " + id_rota);
		List<Ponto> listPontos = appService.buscaPontos(id_rota);
		return listPontos;
	}
	

}
