package br.com.clmDeveloper.mywalkcircling.classes;

import java.io.Serializable;
import java.util.List;

public class ListRotas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2806421523585360625L;
	
	
	private List<Rota> rotas;

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	public ListRotas(List<Rota> rotas) {
		super();
		this.rotas = rotas;
	}

	public ListRotas() {
		super();
	}
	
	

}
