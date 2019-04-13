package br.edu.ifg.sistemacomercial.bean.converter;

import br.edu.ifg.sistemacomercial.entity.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter<Categoria>{

    @Override
    public Categoria getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id != null && !"".equals(id)){
            Categoria categoria = 
                    (Categoria)uic.getAttributes().get("categoria_"+id);
            return categoria;
            
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Categoria t) {
        if(t != null && t.getId() != null){
            uic.getAttributes().put("categoria_"+t.getId(), t);
            return t.getId().toString();
        }
        return "";
    }
    
}
