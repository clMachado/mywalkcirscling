package br.com.clmDeveloper.mywalkcircling.classes;

import java.util.List;

public class RotaAdapter {
	
	private Rota rota;
    private List<Ponto> pontos;

    public RotaAdapter() {
    }
    
    public Rota getRota() {
        return rota;
    }
    public void setRota(Rota rota) {
        this.rota = rota;
    }
    public List<Ponto> getPontos() {
        return pontos;
    }
    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

}
