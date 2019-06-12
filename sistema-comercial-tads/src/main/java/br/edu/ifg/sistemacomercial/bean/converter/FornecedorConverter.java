package br.edu.ifg.sistemacomercial.bean.converter;

import br.edu.ifg.sistemacomercial.entity.Fornecedor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConverter implements Converter<Fornecedor>{

    @Override
    public Fornecedor getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id != null && !"".equals(id)){
            Fornecedor fornecedor = 
                    (Fornecedor)uic.getAttributes().get("fornecedor_"+id);
            return fornecedor;
            
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Fornecedor t) {
        if(t != null && t.getId() != null){
            uic.getAttributes().put("fornecedor_"+t.getId(), t);
            return t.getId().toString();
        }
        return "";
    }
    
}
