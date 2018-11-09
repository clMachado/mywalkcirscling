package br.com.clmDeveloper.mywalkcircling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.clmDeveloper.mywalkcircling.resources.UsuarioAutenticacaoService;

@EnableWebSecurity
public class SegurancaConfiguracao extends WebSecurityConfigurerAdapter{
	@Autowired
	private UsuarioAutenticacaoService usuarioAutenticacaoService;
	
	@Bean
	public PasswordEncoder passwordEncoder(){ // bean que sera usado para criptografar a senha ao salvar 
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		       .antMatchers("/login", "/usuario/**", "/login-error", "/css/**", "/js/**", "/webjars/**").permitAll()  // todos terao acesso a essas pastas/arquivos
		       .antMatchers("/principal","/rota/**","/maps/**", "/").hasAnyRole("USER", "ADMIN")              // PERMITE QUE CORDENADORES E ALUNOS so TENHAM ACESSO A PAGINAS DO PATH ALUNO ou no diretorio / onde esta o index
		       .antMatchers("/**", "/usuario/**").hasAnyRole("ADMIN")                                  // PERMITE QUE ADMIN TENHA ACESSO GERAL  (SE INVERTER AS LINHAS PODE DAR PROBLEMAS NAS PERMISSOES)
		       
		       
		       .anyRequest().authenticated()		       
		    .and()
		    .formLogin()
		       .defaultSuccessUrl("/")
		       .loginPage("/login")
		       .failureUrl("/login-error")
		       ;		
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioAutenticacaoService).passwordEncoder(passwordEncoder());
	}

}
