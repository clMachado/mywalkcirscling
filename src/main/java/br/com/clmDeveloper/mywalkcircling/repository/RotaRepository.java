package br.com.clmDeveloper.mywalkcircling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.clmDeveloper.mywalkcircling.classes.Rota;


@Repository
public interface RotaRepository extends JpaRepository<Rota, Long>{
	
	@Query("select r from Rota r where r.ID = ?1 and r.proprietario = ?2")
	Rota findRota(Long ID, String email);
	
	@Query("select r from Rota r where r.proprietario = ?1")
	Rota findAllRotas(String email);

}
