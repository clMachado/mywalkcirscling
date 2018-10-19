package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

import br.com.clmDeveloper.mywalkcircling.classes.ListRotas;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;


public interface RotaService {
	
	Rota CriarRota(Rota rota);
	
	String CriarRotas(ListRotas rotas);
	
	List<Rota> findAllRotas(String email);

}
