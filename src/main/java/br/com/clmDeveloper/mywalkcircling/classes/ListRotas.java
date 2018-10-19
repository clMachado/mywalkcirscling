package br.com.clmDeveloper.mywalkcircling.classes;

import java.util.ArrayList;
import java.util.List;

public class ListRotas{
	
	//private static final long serialVersionUID = 2806421523585360625L;
	
	private List<Rota> rotas = new ArrayList<>();
	private String msg;
	
	public List<Rota> getRotas() {
		return rotas;
	}
	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public ListRotas() {
		super();
	}
	public ListRotas(List<Rota> rotas, String msg) {
		super();
		this.rotas = rotas;
		this.msg = msg;
	}
	
	public void addRota(Rota rota) {
		this.rotas.add(rota);
	}


}
