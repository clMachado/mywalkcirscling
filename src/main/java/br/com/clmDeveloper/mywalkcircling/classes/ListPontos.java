package br.com.clmDeveloper.mywalkcircling.classes;

import java.io.Serializable;
import java.util.List;

public class ListPontos implements Serializable{
	
	private List<Ponto> pontos;

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
	
	

}
