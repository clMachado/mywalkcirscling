package br.com.clmDeveloper.mywalkcircling.classes;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import com.sun.istack.internal.NotNull;


@Entity
public class Ponto {
	
	@Id
	@SequenceGenerator(name = "ponto_seq", sequenceName = "ponto_seq", allocationSize=1)
	@GeneratedValue(generator = "ponto_seq", strategy = GenerationType.SEQUENCE)
	private Integer ID;
	
	@NotNull
	private Integer id_Rota;
	@NotEmpty
	private String uid_User;
	

	private LocalDate data;
	
	@NotBlank
	private String latitude;
	@NotBlank
	private String longitude;
	private String altitude;
	private Double velocidade;
	private String dataHora;
    private String descricao;
    private Byte imagem;

    /*
	@JsonIgnore // faz com que este campo nao seja retornado em leituras json
	@ManyToOne(fetch = FetchType.LAZY)
	private Rota rota;
	*/

	// teste
	public Ponto() {
		
	}

	public Ponto(Integer id_Rota, @NotEmpty String uid_User, LocalDate data, @NotBlank String latitude,
			@NotBlank String longitude, String altitude, Double velocidade, String dataHora, String descricao) {
		this.id_Rota = id_Rota;
		this.uid_User = uid_User;
		this.data = data;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.velocidade = velocidade;
		this.dataHora = dataHora;
		this.descricao = descricao;
	}

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getId_Rota() {
		return id_Rota;
	}
	public void setId_Rota(Integer id_Rota) {
		this.id_Rota = id_Rota;
	}
	public String getUid_User() {
		return uid_User;
	}
	public void setUid_User(String uid_User) {
		this.uid_User = uid_User;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
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
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Byte getImagem() {
		return imagem;
	}
	public void setImagem(Byte imagem) {
		this.imagem = imagem;
	}


}
