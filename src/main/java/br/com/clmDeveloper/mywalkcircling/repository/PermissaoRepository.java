package br.com.clmDeveloper.mywalkcircling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clmDeveloper.mywalkcircling.classes.Permissao;



@Repository
public interface PermissaoRepository  extends JpaRepository<Permissao, Long>{

}
