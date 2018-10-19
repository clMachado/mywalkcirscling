package br.com.clmDeveloper.mywalkcircling.classes;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Entity
public class Ponto {
	
	@Id
	@SequenceGenerator(name = "ponto_seq", sequenceName = "ponto_seq")
	@GeneratedValue(generator = "ponto_seq", strategy = GenerationType.SEQUENCE)
	private Long ID;	
	
	@NotBlank
	private String latitude;
	@NotBlank
	private String longitude;
	private String altitude;
	private Double velocidade;

	@OneToOne(fetch=FetchType.LAZY)
	private Rota rota;
	
	public Ponto() {
		super();
	}

	public Ponto(@Valid String latitude, @Valid String longitude, String altitude, Double velocidade,
		@Valid Rota rota) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.velocidade = velocidade;
		this.rota = rota;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
	
	
	
	

}
