package br.com.clmDeveloper.mywalkcircling.classes;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Ponto {
	
	@Id
	@SequenceGenerator(name = "ponto_seq", sequenceName = "ponto_seq")
	@GeneratedValue(generator = "ponto_seq", strategy = GenerationType.SEQUENCE)
	private Long ID;
	
	private Long sequencia;
	private LocalDate data;
	
	@NotBlank
	private String latitude;
	@NotBlank
	private String longitude;
	private String altitude;
	private Double velocidade;

	@JsonIgnore // faz com que este campo nao seja retornado em leituras json
	@ManyToOne(fetch = FetchType.LAZY)
	private Rota rota;
	

	// teste
	public Ponto() {
		super(); 
	}

	public Ponto(Long sequencia, LocalDate data, @Valid String latitude, @Valid String longitude, String altitude, Double velocidade,
		@Valid Rota rota) {
		super();
		this.sequencia = sequencia;
		this.data = data;
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

	@JsonIgnore 
	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
	
	

	public Long getSequencia() {
		return sequencia;
	}

	public void setSequencia(Long sequencia) {
		this.sequencia = sequencia;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	@JsonCreator
	public String toString() {
		
		
		
		
		
		
		

		return "Ponto [ID=" + ID + ", latitude=" + latitude + ", longitude=" + longitude + ", altitude=" + altitude
				+ ", velocidade=" + velocidade + "]";
	}

	
	
	

	

	
	
	
	
	

}
