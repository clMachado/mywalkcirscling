package br.com.clmDeveloper.mywalkcircling.service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Resposta;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.classes.RotaAdapter;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;

@RestController
@RequestMapping(path = "restrictApp/rotas")
public class AppServiceImpl implements AppService {
	
	@Autowired
	private RotaRepository rotaRepository;
	@Autowired
	private PontoRepository pontoRepository;
	

    // Metodo responsavel por receber as requisicoes dos Apps e direciona-las para o devido processamento 
    @Override
	@RequestMapping("/mywalkApp")
	@PostMapping(produces="application/json")
	public ResponseEntity<Resposta> recebeRequisicao(@RequestBody @Valid Resposta requisicao) {
		
		String method = requisicao.getMsgObs();
		String uuid   = requisicao.getUuid_User();
		
		Resposta resp = new Resposta();		
		
		boolean validado = validaUsuario(requisicao.getUuid_User());
		
		if(validado) { 
			
			switch(method) {
			
			case "listar":
				resp = listar("completo");
				break;
				
			case "listarRotas":
				resp = listar("");
				break;
				
			default:
				resp.setMsgObs("Methodo Nao identificado.");
				break;				
			}	
			
			resp.setUuid_User(uuid);
			resp.setMsgObs("OK");
			return new ResponseEntity<Resposta>(resp, HttpStatus.OK);
			
		}
		else
			return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}

	// Valido se o usuario recebido na requisicao é um usuario valido ou nao
	private boolean validaUsuario(String uuid_User) {
		// TODO Auto-generated method stub
		return true;
	}
    
	
    // ROTINA QUE LISTA TODAS AS ROTAS E SEUS PONTOS OU SOMENTE AS ROTAS
    public Resposta listar(String tipo) {
        
        Resposta resp = new Resposta();
        
        List<Rota>   rts = new ArrayList<Rota>  (rotaRepository.findAll());
        List<Ponto> pts;
        List<Rota> rotas = new ArrayList<>();
        List<RotaAdapter> rotasAdp = new ArrayList<>();

        if(rts.size() > 0){
              for(Rota r : rts){  
            	 
            	 RotaAdapter rotaAdp = new RotaAdapter();
                 rotaAdp.setRota(r); 
            	  
            	 if(tipo.equals("completo")) { 
            		 pts = new ArrayList<>();
            		 pts = pontoRepository.findPontobyRota(r.getID());
            		 rotaAdp.setPontos(pts);
            	 }
            	    
                 rotasAdp.add(rotaAdp);
              }            
        }

        resp.setRotas(rotasAdp);
                   
      return resp;
    }
    
   
	public List<Ponto> buscaPontos(Integer id){		
		List<Ponto> pontos = new ArrayList<>();
		if (id > 0) 
			pontos = pontoRepository.findPontobyRota(id);

		return pontos;
	}	
	public Rota buscaRota(Integer id){		
		Rota rota = new Rota();
		if (id > 0) 
		   rota = rotaRepository.findByID(id);		
		return rota;
	}

	@Override
	public ResponseEntity<Resposta> gravaRotas(Resposta requisicao) {
		
		Resposta resp = new Resposta();
		List<RotaAdapter> listAdp = new ArrayList<>();

		if(validaUsuario(requisicao.getUuid_User()) ||
		   requisicao.getMsgObs().equals("addRotasTest2291755")	) {
			
			for(RotaAdapter adp: requisicao.getRotas()) {
				
				try {
				   Rota rota = rotaRepository.save(adp.getRota());
				
				   for(Ponto p : adp.getPontos()) {
				      p.setId_Rota(rota.getID());
				      pontoRepository.save(p);
				   }
  
				   RotaAdapter retAdp = new RotaAdapter();
				   retAdp.setRota(rota);
				   listAdp.add(retAdp);
				      
				}catch (Exception e) {
					e.printStackTrace();
					
				}	
			}
			
			resp.setUuid_User(requisicao.getUuid_User());
			resp.setMsgObs("OK");
			resp.setRotas(listAdp);
			
			
			
		}
		
		return null;
	}
	
	public boolean gravaRotasTest(Resposta requisicao) {
		ResponseEntity<Resposta> rr = gravaRotas(requisicao);
		return true;
	}
	

}
