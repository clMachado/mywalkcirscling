package br.com.clmDeveloper.mywalkcircling.classes;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;

@Entity
public class Rota {
	
	@Id
	@SequenceGenerator(name = "rota_seq", sequenceName = "rota_seq")
	@GeneratedValue(generator = "rota_seq", strategy = GenerationType.SEQUENCE)
	private Long ID;	
	
	@Valid
	private String descricao;
	private Double distancia;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//private Usuario user;
	
	private String proprietario;


	public Rota(Long iD, String descricao, Double distancia, String proprietario) {
		super();
		ID = iD;
		this.descricao = descricao;
		this.distancia = distancia;
		this.proprietario = proprietario;
	}
	public Rota() {
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
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
		
	
}
