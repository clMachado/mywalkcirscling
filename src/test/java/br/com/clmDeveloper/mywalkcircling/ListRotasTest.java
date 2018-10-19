package br.com.clmDeveloper.mywalkcircling;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.ListRotas;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;
import br.com.clmDeveloper.mywalkcircling.resources.RotaService;
import br.com.clmDeveloper.mywalkcircling.resources.RotaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MywalkcirclingApplication.class)
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
	    List<Ponto> pts = new ArrayList<Ponto>();
	    pts.add(p);
	    pts.add(p2);

		p.setRota(r);
		p2.setRota(r);
		list.addPonto(p);
		list.addPonto(p2);	
		
	
		
		
	}

}
