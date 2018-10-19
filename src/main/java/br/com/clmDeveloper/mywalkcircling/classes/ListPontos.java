package br.com.clmDeveloper.mywalkcircling.classes;

import java.io.Serializable;
import java.util.List;

public class ListPontos implements Serializable{
	
	private static final long serialVersionUID = 2806421523585360626L;
	
	private List<Ponto> pontos;
	private String msg;

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	public ListPontos(List<Ponto> pontos) {
		super();
		this.pontos = pontos;
	}

	public ListPontos() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void addPonto(Ponto ponto) {
		this.pontos.add(ponto);
	}
	
	
	

}
