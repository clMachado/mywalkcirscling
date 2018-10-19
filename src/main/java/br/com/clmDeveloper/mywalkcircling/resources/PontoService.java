package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

import com.google.gson.Gson;

import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;

public interface PontoService {
	
	ListPontos CriarPonto(Ponto ponto);
	
	ListPontos CriarPontos(ListPontos pontos);
	
	ListPontos findPontosByRota(Long sid_rota);

}
