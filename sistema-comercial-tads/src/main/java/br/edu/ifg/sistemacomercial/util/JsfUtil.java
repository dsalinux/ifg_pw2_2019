package br.edu.ifg.sistemacomercial.util;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JsfUtil implements Serializable{

    public void addMensagem(FacesMessage.Severity severidade, String resumo, String detalhe){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severidade,resumo,detalhe));
    }
    
    public void addMensagem(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_INFO,resumo, detalhe);
    }
    
    public void addMensagem(String resumo){
        addMensagem(resumo, null);
    }
    
}
