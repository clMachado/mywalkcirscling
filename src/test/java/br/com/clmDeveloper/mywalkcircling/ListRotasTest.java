package br.com.clmDeveloper.mywalkcircling;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=MywalkcirclingApplication.class)
public class ListRotasTest {
	
	@Test
	public void testListRotas() {

		Rota r = new Rota("123123123", "teste", 0.0); 
				
		System.out.println(r.toString());	
	}
	
	@Test
	public void testListPontos() {
        

		Rota r = new Rota("123123123", "teste", 0.0); 
		
		Ponto p = new Ponto();
		p.setId_Rota(r.getID());
		
		Ponto p2 = new Ponto();
		p2.setId_Rota(r.getID());
		
	    List<Ponto> pts = new ArrayList<Ponto>();
	    pts.add(p);
	    pts.add(p2);
	    
	}

}
