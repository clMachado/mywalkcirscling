package br.com.clmDeveloper.mywalkcircling.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.clmDeveloper.mywalkcircling.classes.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@EntityGraph(attributePaths="permissoes") // quando fizer a query do find carrega-ra a lista de permissoes tambem
	Usuario findByUsername(String username);
	
	@EntityGraph(attributePaths="permissoes") // quando fizer a query do find carrega-ra a lista de permissoes tambem
	Usuario findByCodigo(Long codigo);

}
