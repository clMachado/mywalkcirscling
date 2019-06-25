package br.com.clmDeveloper.mywalkcircling.classes;

import java.util.List;

public class Resposta {
	
	private String uuid_User;
    private List<RotaAdapter> rotas;
    private String msgObs;

    public String getUuid_User() {
        return uuid_User;
    }
    public void setUuid_User(String uuid_User) {
        this.uuid_User = uuid_User;
    }
    public List<RotaAdapter> getRotas() {
        return rotas;
    }
    public void setRotas(List<RotaAdapter> rotas) {
        this.rotas = rotas;
    }
    public String getMsgObs() {
        return msgObs;
    }
    public void setMsgObs(String msgObs) {
        this.msgObs = msgObs;
    }
    
}
