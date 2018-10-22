package br.com.clmDeveloper.mywalkcircling.resources;

import br.com.clmDeveloper.mywalkcircling.classes.ListRotas;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;


public interface RotaService {
	
	ListRotas CriarRota(Rota rota);
	
	ListRotas CriarRotas(ListRotas rotas);
	
	ListRotas findAllRotas(String email);
	
	ListRotas findAllRotasPontos(String email);
	
	ListRotas findAllRotaPontos(Long rota);

}
