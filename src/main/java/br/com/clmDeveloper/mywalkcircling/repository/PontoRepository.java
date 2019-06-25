package br.com.clmDeveloper.mywalkcircling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
	
	@Query("select p from Ponto p where p.id_Rota = ?1")
	List<Ponto> findPontobyRota(Integer id_Rota);

	@Query("delete from Ponto p where p.id_Rota = ?1")
	void deleteById_Rota(Integer iD);

}
