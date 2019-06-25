package br.com.clmDeveloper.mywalkcircling.classes;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Rota {
	
	@Id
	@SequenceGenerator(name = "rota_seq", sequenceName = "rota_seq", allocationSize=1)
	@GeneratedValue(generator = "rota_seq", strategy = GenerationType.SEQUENCE )
	private Integer ID;	 
	
	@NotBlank
	private String uid_User;
	
	private String proprietario;
	
	@NotBlank
	private String descricao;
	
	private Double distancia;	
	/*
	@OneToMany(mappedBy = "rota", targetEntity = Ponto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OneToMany(mappedBy = "rota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ponto> pontos = new ArrayList<>();	

	@Transient
	//@JsonIgnore
	private List<Ponto> pontos = new ArrayList<>();
*/
	
	public Rota(String uid_User, String descricao, Double distancia) {
		this.uid_User = uid_User;
		this.descricao = descricao;
		this.distancia = distancia;;
	}
	
	public Rota() {
		super();
	}
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public String getUid_User() {
		return uid_User;
	}
	public void setUid_User(String uid_User) {
		this.uid_User = uid_User;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	
}
