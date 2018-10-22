package br.com.clmDeveloper.mywalkcircling.resources;

import org.springframework.data.jpa.repository.EntityGraph;

import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;

public interface PontoService {
	
	ListPontos CriarPonto(Ponto ponto);
	
	ListPontos CriarPontos(ListPontos pontos);
	
	ListPontos findPontosByRota(Long sid_rota);

}
