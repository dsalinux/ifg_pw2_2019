package br.edu.ifg.sistemacomercial.util;

import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void addMensagemAviso(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_WARN, resumo, detalhe);
    }
    public void addMensagemAviso(String resumo){
        addMensagemAviso(resumo, null);
    }

    public void addMensagemErro(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }
    public void addMensagemErro(String resumo){
        addMensagemErro(resumo, null);
    }
    public void addMensagemErro(NegocioException ex){
        addMensagemErro(ex.getMessage(), null);
        Logger.getLogger(JsfUtil.class.getName()).log(Level.WARNING, null, ex);
    }
    
    public void addMensagemFatal(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_FATAL, resumo, detalhe);
    }
    public void addMensagemFatal(String resumo){
        addMensagemFatal(resumo, null);
    }
    public void addMensagemFatal(SistemaException ex){
        addMensagemFatal(ex.getMessage(), null);
        Logger.getLogger(JsfUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
}
