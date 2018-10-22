package br.com.clmDeveloper.mywalkcircling.classes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rota {
	
	@Id
	@SequenceGenerator(name = "rota_seq", sequenceName = "rota_seq")
	@GeneratedValue(generator = "rota_seq", strategy = GenerationType.SEQUENCE)
	private Long ID;	 
	
	@NotBlank
	private String descricao;
	@NotBlank
	private String email;
	
	private Double distancia;	
	/*
	@OneToMany(mappedBy = "rota", targetEntity = Ponto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OneToMany(mappedBy = "rota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ponto> pontos = new ArrayList<>();	
*/
	@Transient
	//@JsonIgnore
	private List<Ponto> pontos = new ArrayList<>();
	
	public Rota(Long ID, String descricao, Double distancia, String email) {
		super();
		this.ID = ID;
		this.descricao = descricao;
		this.distancia = distancia;
		this.email = email;
	}
	
/*	public Rota(Long ID, String descricao, Double distancia, String email, List<Ponto> pontos) {
		super();
		this.ID = ID;
		this.descricao = descricao;
		this.distancia = distancia;
		this.email = email;
		this.pontos = pontos;
	}
*/
	public Rota() {
		super();
	}
	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public List<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Rota [ID=" + ID + ", descricao=" + descricao + ", email=" + email + ", distancia=" + distancia
				+ "";
	}
	
	public void addPonto(Ponto ponto) {
		this.pontos.add(ponto);
	}
	
	
}
