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
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// retorna lista de usuarios para teste
	
	@RequestMapping({"","/"})
	@GetMapping(produces="application/json")
	public Iterable<Usuario> listaUsuarios(){
		Iterable<Usuario> it = usuarioRepository.findAll();
		return it;
	}

	@Override
	@RequestMapping("/add")
	@PostMapping(produces="application/json")
	public Usuario CriarUsuario(@RequestBody @Valid Usuario us) {
		System.out.println("Criando Usuario!!  Email: " + us.getEmail() + " Senha: " + us.getSenha() + " Nome: " + us.getNome() );
		return usuarioRepository.save(us);		
	}

	@Override
	@RequestMapping("/login")
	@PostMapping(produces="application/json")
	public Usuario FazerLogin(@RequestBody @Valid Usuario us) {
		
		Usuario usret = new Usuario();
		usret = us;
		
		System.out.println("Fazendo Login Usuario!!  Email: " + us.getEmail() + " Senha: " + us.getSenha());
		
	    us = usuarioRepository.findByUsuario(us.getEmail(), us.getSenha());
	    
	    if(us != null)
	       System.out.println("Usuario Logado!!  Email: " + us.getEmail() + " Senha: " + us.getSenha() + " Nome: " + us.getNome() );
	    else {
	    	System.out.println("Login Invalido!!");
	    	   	
	    	usret.setNome("Login Invalido!!");
	    	us = usret;
	    }
	    
	    return us;
	}

}
