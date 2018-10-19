package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

import com.google.gson.Gson;

import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;

public interface PontoService {
	
	Ponto CriarPonto(Ponto ponto);
	
	boolean CriarPontos(ListPontos pontos);
	
	List<Ponto> findPontosByRota(Rota rota);

}
