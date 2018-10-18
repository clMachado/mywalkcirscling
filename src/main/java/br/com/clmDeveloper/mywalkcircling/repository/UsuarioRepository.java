package br.com.clmDeveloper.mywalkcircling.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.clmDeveloper.mywalkcircling.classes.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	@Query("select u from Usuario u where u.email = ?1 and u.senha = ?2")
	Usuario findByUsuario(String email, String senha);

}
