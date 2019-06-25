package br.com.clmDeveloper.mywalkcircling.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;


@Repository
public interface RotaRepository extends JpaRepository<Rota, Integer>{
	
	//@Query("select r from Rota r where r.ID = ?1 and r.email = ?2")
	//Rota findRota(Long ID, String email);
	
	//@Query("select r from Rota r where r.email = ?1")
	//List<Rota> findAllRotas(String email);
	
	@Query("select r from Rota r where r.ID = ?1")
	Rota findByID(Integer id);
	
}
