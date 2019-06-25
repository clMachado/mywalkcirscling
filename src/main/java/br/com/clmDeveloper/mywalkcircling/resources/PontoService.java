package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.clmDeveloper.mywalkcircling.classes.Ponto;

public interface PontoService {
	/*
	ListPontos CriarPonto(Ponto ponto);
	
	ListPontos CriarPontos(ListPontos pontos);
	*/
	List<Ponto> findPontosByRota(Integer id_rota);

}
