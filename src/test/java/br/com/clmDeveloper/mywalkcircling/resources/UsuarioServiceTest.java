package br.com.clmDeveloper.mywalkcircling.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.clmDeveloper.mywalkcircling.MywalkcirclingApplication;
import br.com.clmDeveloper.mywalkcircling.classes.Permissao;
import br.com.clmDeveloper.mywalkcircling.classes.Ponto;
import br.com.clmDeveloper.mywalkcircling.classes.Resposta;
import br.com.clmDeveloper.mywalkcircling.classes.Rota;
import br.com.clmDeveloper.mywalkcircling.classes.RotaAdapter;
import br.com.clmDeveloper.mywalkcircling.classes.Usuario;
import br.com.clmDeveloper.mywalkcircling.repository.PermissaoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.PontoRepository;
import br.com.clmDeveloper.mywalkcircling.repository.RotaRepository;
import br.com.clmDeveloper.mywalkcircling.repository.UsuarioRepository;
import br.com.clmDeveloper.mywalkcircling.service.AppService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MywalkcirclingApplication.class)
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioServiceImpl us;
	
	@Autowired
	PermissaoRepository perm;
	//@Autowired
	//RotaServiceImpl    rt ;
	//@Autowired
	//PontoServiceImpl   ps ;
	
	@Autowired
	AppService appService;
	
	@Autowired
	UsuarioRepository ur;
	@Autowired
	PontoRepository   pr;
	@Autowired
	RotaRepository    rr;
	@Autowired		
	private PasswordEncoder passCoder;
	
	@Before
	public void deleta1() {
		ur.deleteAll();
		pr.deleteAll();
		rr.deleteAll();
		perm.deleteAll();
	}
	/*
	@After
	public void deleta2() {
		ur.deleteAll();
		pr.deleteAll();
		rr.deleteAll();
		perm.deleteAll();		
	}*/
	
	
	
	@Test
	public void testListEuserRotasPontos() {
		
		Permissao permissao1 = new Permissao();
		permissao1.setAuthority("ROLE_ADMIN");
		perm.save(permissao1);
		
		Permissao permisao2 = new Permissao();
		permisao2.setAuthority("ROLE_USER");
		perm.save(permisao2);
		

		Usuario user = new Usuario("111111", "mxd.maxado@gmail.com", passCoder.encode("adm123"), "Cleverson Machado");
		user.addPermissao(permissao1);
		
		us.CriarUsuario(user); 
		
		Usuario user2 = new Usuario("123123123", "juca.bala@gmail.com", passCoder.encode("adm111"), "Juca Bala");
		
		user2.addPermissao(permisao2);
		us.CriarUsuario(user2);
	
	    Resposta resp = new Resposta();
	    List<RotaAdapter> rotas = new ArrayList<>();
	    
	    resp.setRotas(rotas);
		
		Rota r1 =  new Rota();
		r1.setDescricao("Rota 1");
		r1.setDistancia(1.0);
		r1.setUid_User(user.getUuID());
		
		Rota r2 =  new Rota();
		r2.setDescricao("Rota 2");
		r2.setDistancia(3.0);
		r2.setUid_User(user2.getUuID());
		
		
		List<Ponto> pontos = new ArrayList<>();

		pontos.add(new Ponto( r1.getID(), r1.getUid_User(), LocalDate.of(2018, 11, 02), "-25.8346683", "-52.727471", "0.0", 0.0, "", ""));
		pontos.add(new Ponto( r1.getID(), r1.getUid_User(), LocalDate.of(2018, 11, 02), "-25.8347775", "-52.7249978", "0.0", 0.0, "", ""));
		pontos.add(new Ponto( r1.getID(), r1.getUid_User(), LocalDate.of(2018, 11, 02), "-25.8363548", "-52.7247626", "0.0", 0.0, "", ""));
		pontos.add(new Ponto( r1.getID(), r1.getUid_User(), LocalDate.of(2018, 11, 02), "-25.8362797", "-52.7272054", "0.0", 0.0, "", ""));
		//r1.setPontos(pontos);
		RotaAdapter adp = new RotaAdapter();
		adp.setRota(r1);
		adp.setPontos(pontos);
		rotas.add(adp);
		
		
		List<Ponto> pontos2 = new ArrayList<>();
		pontos2.add(new Ponto( r2.getID(), r2.getUid_User(), LocalDate.of(2018, 11, 02), "-51", "-28.1", "0.0", 0.0, "", ""));
		pontos2.add(new Ponto( r2.getID(), r2.getUid_User(), LocalDate.of(2018, 11, 02), "-51", "-28.2", "0.0", 0.0, "", ""));
		
		RotaAdapter adp2 = new RotaAdapter();
		adp2.setRota(r2);
		adp2.setPontos(pontos2);
		rotas.add(adp2);
		

		resp.setRotas(rotas);
		resp.setMsgObs("addRotasTest2291755");
		
		
        // salvo as rotas e os pontos vinculados a ela
		appService.gravaRotasTest(resp);
		

	}

}
