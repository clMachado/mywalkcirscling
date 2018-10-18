package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.List;

import br.com.clmDeveloper.mywalkcircling.classes.Rota;


public interface RotaService {
	
	Rota CriarRota(Rota rota);
	List<Rota> findAllRotas(String email);

}
