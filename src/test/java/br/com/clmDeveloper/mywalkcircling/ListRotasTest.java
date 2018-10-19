package br.com.clmDeveloper.mywalkcircling;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.ListRotas;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;

public class ListRotasTest {
	
	@Test
	public void testListRotas() {
        ListRotas list = new ListRotas();
		Rota r = new Rota(1L, "teste", 0.0, "juca.com");
		
		System.out.println(r.toString());
		list.addRota(r);
		
	}
	
	@Test
	public void testListPontos() {
        ListPontos list = new ListPontos();
		Rota r = new Rota(1L, "teste", 0.0, "juca.com");
		Ponto p = new Ponto();
		Ponto p2 = new Ponto();
		p.setRota(r);
		p2.setRota(r);
		list.addPonto(p);
		list.addPonto(p2);	
	}

}
