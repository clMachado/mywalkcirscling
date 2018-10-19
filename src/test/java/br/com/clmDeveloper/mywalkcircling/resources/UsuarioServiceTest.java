package br.com.clmDeveloper.mywalkcircling.resources;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clmDeveloper.mywalkcircling.MywalkcirclingApplication;
import br.com.clmDeveloper.mywalkcircling.classes.ListPontos;
import br.com.clmDeveloper.mywalkcircling.classes.ListRotas;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.classes.Usuario;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;
import br.com.clmDeveloper.mywalkcircling.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MywalkcirclingApplication.class)
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioServiceImpl us;
	@Autowired
	RotaServiceImpl    rt ;
	@Autowired
	PontoServiceImpl   ps ;
	
	@Autowired
	UsuarioRepository ur;
	@Autowired
	PontoRepository   pr;
	@Autowired
	RotaRepository    rr;
	
	@Before
	public void deleta1() {
		ur.deleteAll();
		pr.deleteAll();
		rr.deleteAll();		
	}
	
	@After
	public void deleta2() {
		ur.deleteAll();
		pr.deleteAll();
		rr.deleteAll();		
	}
	
	
	
	@Test
	public void testListEuserRotasPontos() {
		Usuario user = new Usuario("mxd.maxado@gmail.com", "adm123", "Cleverson Machado");		
		//ur.save(user);
		us.CriarUsuario(user);
		
		Usuario user2 = new Usuario("juca.bala@gmail.com", "adm1232323", "Juca Bala");		
		//ur.save(user2);
		us.CriarUsuario(user2);
		
		ListRotas rotas = new ListRotas();
		
		Rota r1 =  new Rota();
		r1.setDescricao("Rota 1");
		r1.setDistancia(1.0);
		r1.setEmail(user.getEmail());
		
		Rota r2 =  new Rota();
		r2.setDescricao("Rota 2");
		r2.setDistancia(3.0);
		r2.setEmail(user2.getEmail());
		
		
		List<Ponto> pontos = new ArrayList<>();
		pontos.add(new Ponto("-51", "-28", "", 1.0 , r1));
		pontos.add(new Ponto("-51.1", "-28", "", 1.0 , r1));
		pontos.add(new Ponto("-51.2", "-28", "", 1.0 , r1));
		pontos.add(new Ponto("-51.3", "-28", "", 1.0 , r1));
		//r1.setPontos(pontos);
		
		ListPontos pontosLS = new ListPontos();
		pontosLS.setPontos(pontos);
		
		
		List<Ponto> pontos2 = new ArrayList<>();
		pontos2.add(new Ponto("-51", "-28.1", "", 1.0 , r2));
		pontos2.add(new Ponto("-51", "-28.2", "", 1.0 , r2));
		//r2.setPontos(pontos2);
		
		ListPontos pontosLS2 = new ListPontos();
		pontosLS2.setPontos(pontos2);
		
		rotas.addRota(r1);
		rotas.addRota(r2);
		
		rt.CriarRotas(rotas);
		
		ps.CriarPontos(pontosLS);
		ps.CriarPontos(pontosLS2);

	}

}
