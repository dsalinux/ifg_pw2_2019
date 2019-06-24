package br.edu.ifg.sistemacomercial.bean.converter;

import br.edu.ifg.sistemacomercial.entity.Conta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Conta.class)
public class ContaConverter implements Converter<Conta>{

    @Override
    public Conta getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id != null && !"".equals(id)){
            Conta conta = 
                    (Conta)uic.getAttributes().get("conta_"+id);
            return conta;
            
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Conta t) {
        if(t != null && t.getId() != null){
            uic.getAttributes().put("conta_"+t.getId(), t);
            return t.getId().toString();
        }
        return "";
    }
    
}
