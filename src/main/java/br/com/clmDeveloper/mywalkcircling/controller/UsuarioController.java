package br.com.clmDeveloper.mywalkcircling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.clmDeveloper.mywalkcircling.classes.Usuario;
import br.com.clmDeveloper.mywalkcircling.repository.PermissaoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.UsuarioRepository;



@Controller
@RequestMapping("/usuario") //todas as urls irão iniciar com /curso
public class UsuarioController {
	
		@Autowired
		private UsuarioRepository usuarioRepositorio;
		
		@Autowired
		private PermissaoRepository permissaoRepositorio;
		
		@Autowired		
		private PasswordEncoder passCoder;
		
		
		
		@GetMapping({"/",""})
		public String lista(Model model){
			//${dados} será a variável disponível no template thymeleaf
			model.addAttribute("dados",usuarioRepositorio.findAll());
			return "usuario/lista"; //arquivo .html dentro da pasta resources/templates
		}
		
		@GetMapping("/novo")
		public String novo(Model model){
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("titulo","Criar Usuario");
			model.addAttribute("allpermissoes", permissaoRepositorio.findAll());
			return "usuario/formulario";
		}
		
		@PostMapping("/salvar")
		public String salvar(Usuario user, @RequestParam Long codigoPermissao){ //codigoPermissao deve ser o mesmo elemento do html para conseguir pegar aqui
			
			user.setUsername(user.getEmail());

			if(user.getPassword().isEmpty()){ // se senha for vazia 
				if(user.getCodigo() != null){			//e se for alteracao (nao esta alterando senha pois esta vazia)
				    Usuario userAtual = usuarioRepositorio.findById(user.getCodigo()).get(); // busco a senha velha e gravo ela novamente
				    user.setPassword(userAtual.getPassword());
			    }
			}
			else{
			   user.setPassword(passCoder.encode(user.getPassword()));          // criptografo a senha
			}
						
			user.addPermissao(permissaoRepositorio.getOne(codigoPermissao)); // busco a permissao para vincular
			usuarioRepositorio.save(user);
			return "redirect:/usuario/";
		}

		
		@GetMapping("/visualizar/{codigo}")
		public String visualizar(@PathVariable Long codigo, Model model){
			Usuario user = usuarioRepositorio.findByCodigo(codigo);
			
			if (user == null){
				user = new Usuario();
				model.addAttribute("titulo","Criar Usuario");
			}
			else
				model.addAttribute("titulo","Alterar Usuario");
			
			//model.addAttribute("permissao", user.getPermissoes());
			model.addAttribute("usuario", user);
			model.addAttribute("allpermissoes", permissaoRepositorio.findAll());
			return "usuario/formulario";
		}
		
		
		@GetMapping("/remover/{codigo}")
		public String remover(@PathVariable Long codigo, Model model){
			usuarioRepositorio.deleteById(codigo);
			return "redirect:/usuario/";
		}

}
