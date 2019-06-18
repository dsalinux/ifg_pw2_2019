package br.edu.ifg.sistemacomercial.bean.converter;

import br.edu.ifg.sistemacomercial.entity.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter<Cliente>{

    @Override
    public Cliente getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id != null && !"".equals(id)){
            Cliente cliente = 
                    (Cliente)uic.getAttributes().get("cliente_"+id);
            return cliente;
            
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cliente t) {
        if(t != null && t.getId() != null){
            uic.getAttributes().put("cliente_"+t.getId(), t);
            return t.getId().toString();
        }
        return "";
    }
    
}
