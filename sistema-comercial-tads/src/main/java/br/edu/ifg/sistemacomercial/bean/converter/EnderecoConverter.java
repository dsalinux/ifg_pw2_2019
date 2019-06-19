package br.edu.ifg.sistemacomercial.bean.converter;

import br.edu.ifg.sistemacomercial.entity.Endereco;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Endereco.class)
public class EnderecoConverter implements Converter<Endereco>{

    @Override
    public Endereco getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id != null && !"".equals(id)){
            Endereco endereco = 
                    (Endereco)uic.getAttributes().get("endereco_"+id);
            return endereco;
            
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Endereco t) {
        if(t != null && t.getId() != null){
            uic.getAttributes().put("endereco_"+t.getId(), t);
            return t.getId().toString();
        }
        return "";
    }
    
}
