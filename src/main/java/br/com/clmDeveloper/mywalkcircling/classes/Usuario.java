package br.com.clmDeveloper.mywalkcircling.classes;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = -469759354805228603L;

	@Id
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize=1)
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@NotEmpty
	private String uuID;

	@NotBlank
	@NotNull
	private String email;
	
	@NotEmpty
	private String username;

	@NotBlank
	@NotNull
	@Column(length = 200, nullable = false)
	private String password;

	@NotNull
	@Column(length = 150, nullable = false)
	private String nome;
	
	@ManyToMany
	private Collection<Permissao> permissoes;
	
	
	



	public Usuario( @NotEmpty String uuID, @NotBlank @NotNull String email, @NotBlank @NotNull String password, @NotNull String nome, Collection<Permissao> permissoes) {
		super();
		this.uuID = uuID;
		this.email = email;
		this.username = email;
		this.password = password;
		this.nome = nome;
		this.permissoes = permissoes;
	}
	public Usuario( @NotEmpty String uuID, @NotBlank @NotNull String email, @NotBlank @NotNull String password, @NotNull String nome ) {
		super();
		this.uuID = uuID;
		this.email = email;
		this.username = email;
		this.password = password;
		this.nome = nome;
	}

	public Usuario() {
		super();
	}

	public void addPermissao(Permissao permissao) {
		if (permissoes == null) {
			permissoes = new HashSet<>(); // garante que nao se repita, nao tera
											// 2 iguais
		}
		permissoes.add(permissao);
	}

	public void removePermissao(Permissao permissao) {
		if (permissoes != null) {
			permissoes.remove(permissao);
		}
	}
	
	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		this.username = email;
	}
	public String getUuID() {
		return uuID;
	}
	public void setUuID(String uuID) {
		this.uuID = uuID;
	}
	

	// medotos herdados da implementacao
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissoes; 					
	}
	@Override
	public boolean isAccountNonExpired() { // conta nao esta expirada ?
		return true;
	}
	@Override
	public boolean isAccountNonLocked() { // conta nao bloqueada?
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() { // senha nao espirada ?
		return true;
	}
	@Override
	public boolean isEnabled() { // usuario habilitado ?
		return true;
	}
	@Override
	public String getUsername() {
		return username;
	}

}
