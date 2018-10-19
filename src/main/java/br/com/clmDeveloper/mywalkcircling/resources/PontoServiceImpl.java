package br.com.clmDeveloper.mywalkcircling.resources;


import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/reposit/pontos")
public class PontoServiceImpl implements PontoService{

	@Autowired
	private PontoRepository pontoRepository;
	
	@Autowired
	private RotaRepository rotaRepository;
	
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
	
	// ROTINA ABAIXO ESTA RETORNANDO JSON EM LOOP POR ISSO ESTA COMENTADA (referencia cruzada rota-ponto )
	
	@Override
	@GetMapping(produces="application/json")
	@RequestMapping("/getPontos/{id_rota}")
	public ListPontos findPontosByRota(@PathVariable Long id_rota) {	
		
		System.out.println("veio " + id_rota);
		
		listPontos = new ListPontos();
		
		System.out.println("VEIO ID " + id_rota);
		Rota rota = null;
		
		// busco a rota referente ao ID recebido
        try {
		   rota = rotaRepository.findByID(id_rota);
        }catch (Exception e) {
			listPontos.setMsg(e.toString());
			return listPontos;
		}
        
        
        
		if (rota == null) {
			listPontos.setMsg("Nenhuma Rota localizada para o ID informado. (" + id_rota + ")");
		}
		// Busco os pontos referentes a rota
		else {
		   //listPontos.setPontos(rota.getPontos());	
		   listPontos.setPontos(pontoRepository.findPontobyRota(rota));
		}
		if (listPontos.getPontos().toString() == "[]")
		   listPontos.setMsg("Rota Sem nenhum ponto vinculado!!");
		
		return listPontos;
	}

}
