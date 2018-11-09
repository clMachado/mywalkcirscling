package br.com.clmDeveloper.mywalkcircling.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clmDeveloper.mywalkcircling.classes.Usuario;
import br.com.clmDeveloper.mywalkcircling.repository.UsuarioRepository;


@RestController
@Service
@RequestMapping("/reposit/usuario") 
public class UsuarioServiceImpl { //implements UsuarioService{
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// retorna lista de usuarios para teste
	
	@RequestMapping({"","/"})
	@GetMapping(produces="application/json")
	public Iterable<Usuario> listaUsuarios(){
		Iterable<Usuario> it = usuarioRepository.findAll();
		return it;
	}

	

	@RequestMapping("/add")
	@PostMapping(produces="application/json")
	public Usuario CriarUsuario(@RequestBody @Valid Usuario us) {
		System.out.println("Criando Usuario!!  Email: " + us.getEmail() + "Username: " + us.getUsername() + " Senha: " + us.getPassword() + " Nome: " + us.getNome() );
		return usuarioRepository.save(us);		
	}

	
}
