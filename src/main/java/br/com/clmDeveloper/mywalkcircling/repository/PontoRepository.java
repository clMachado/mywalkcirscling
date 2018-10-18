package br.com.clmDeveloper.mywalkcircling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
	
	@Query("select p from Ponto p where p.email = ?1 and p.rota = ?2")
	List<Ponto> findPontobyRota(String email, Rota rota);

}
