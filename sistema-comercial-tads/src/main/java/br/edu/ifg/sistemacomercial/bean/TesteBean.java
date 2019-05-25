package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.util.JsfUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TesteBean extends JsfUtil{
    
    public void metodoLento(){
        long milisAtuais = System.currentTimeMillis();
        long milisCom3Segundos = milisAtuais+3000;
        while(milisAtuais < milisCom3Segundos){
            //Fica atualizando o milis
            milisAtuais = System.currentTimeMillis();
        }
        addMensagem("Ufa... Terminou.");
    }
    
}
