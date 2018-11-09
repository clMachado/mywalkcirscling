package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;

import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;

public interface PontoService {
	
	ListPontos CriarPonto(Ponto ponto);
	
	ListPontos CriarPontos(ListPontos pontos);
	
	List<Ponto> findPontosByRota(Long sid_rota);

}
