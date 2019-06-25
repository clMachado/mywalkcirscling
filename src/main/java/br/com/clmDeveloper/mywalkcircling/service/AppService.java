package br.com.clmDeveloper.mywalkcircling.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Resposta;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;

public interface AppService {
	
	ResponseEntity<Resposta> recebeRequisicao(Resposta requisicao);	

	Resposta listar(String tipo);
	
	Rota buscaRota(Integer id);
	
	List<Ponto> buscaPontos(Integer id);
	
	ResponseEntity<Resposta> gravaRotas(Resposta requisicao);	
	
	boolean gravaRotasTest(Resposta requisicao);	

}
