package br.edu.ifg.sistemacomercial.bean.converter;

import br.edu.ifg.sistemacomercial.entity.Permissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Permissao.class, value = "permissaoConverter")
public class PermissaoConverter implements Converter<Permissao>{

    @Override
    public Permissao getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id != null && !"".equals(id)){
            Permissao permissao = 
                    (Permissao)uic.getAttributes().get("permissao_"+id);
            return permissao;
            
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Permissao t) {
        if(t != null && t.getId() != null){
            uic.getAttributes().put("permissao_"+t.getId(), t);
            return t.getId().toString();
        }
        return "";
    }
    
}
