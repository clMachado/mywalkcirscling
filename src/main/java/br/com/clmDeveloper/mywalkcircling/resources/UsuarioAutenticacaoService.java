package br.com.clmDeveloper.mywalkcircling.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.clmDeveloper.mywalkcircling.repository.UsuarioRepository;



@Service
public class UsuarioAutenticacaoService implements UserDetailsService{
	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		return usuarioRepositorio.findByUsername(username);
	}

}
