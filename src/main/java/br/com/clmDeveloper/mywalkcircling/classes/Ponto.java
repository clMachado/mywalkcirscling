package br.com.clmDeveloper.mywalkcircling.classes;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;

import org.springframework.data.annotation.Id;

@Entity
public class Ponto {
	
	@Id
	@SequenceGenerator(name = "ponto_seq", sequenceName = "ponto_seq")
	@GeneratedValue(generator = "ponto_seq", strategy = GenerationType.SEQUENCE)
	private Long ID;	
	
	@Valid
	private String latitude;
	@Valid
	private String longitude;
	private String altitude;
	private Double velocidade;
	@Valid
	private String email;
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	private Rota Rota;
	
	public Ponto() {
		super();
	}

	public Ponto(@Valid String latitude, @Valid String longitude, String altitude, Double velocidade,
			@Valid String email, br.com.clmDeveloper.mywalkcircling.classes.@Valid Rota rota) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.velocidade = velocidade;
		this.email = email;
		Rota = rota;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rota getRota() {
		return Rota;
	}

	public void setRota(Rota rota) {
		Rota = rota;
	}
	
	
	
	

}
