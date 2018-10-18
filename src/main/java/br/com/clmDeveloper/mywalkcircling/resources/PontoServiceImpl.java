package br.com.clmDeveloper.mywalkcircling.resources;

/*
@Service
@RestController
@RequestMapping("/pontos")*/
public class PontoServiceImpl { //implements PontoService{
/*
	@Autowired
	private PontoRepository pontoRepository;
	
	@Override
	@RequestMapping("/addPonto")
	@PostMapping(produces="application/json")
	public Ponto CriarPonto(@RequestBody @Valid Ponto ponto) {
		return pontoRepository.save(ponto);
	}
	
	@Override
	@RequestMapping("/addPontos")
	@PostMapping(produces="application/json")
	public boolean CriarPontos(@RequestBody @Valid List<Ponto> pontos) {
		try {
			for (Ponto ponto : pontos) {
				CriarPonto(ponto);			
			}		
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	@GetMapping(produces="application/json")
	@RequestMapping("/getPontos")
	public List<Ponto> findPontosByRota(String email, Rota rota) {		
		return pontoRepository.findPontobyRota(email, rota);
	}
*/
}
