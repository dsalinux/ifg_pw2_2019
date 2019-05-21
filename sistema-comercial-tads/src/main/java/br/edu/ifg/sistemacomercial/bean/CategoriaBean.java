package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Categoria;
import br.edu.ifg.sistemacomercial.logic.CategoriaLogic;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CategoriaBean extends GenericCrud<Categoria, CategoriaLogic>{

    @Inject
    private CategoriaLogic logic;
    
    @Override
    public CategoriaLogic getLogic() {
        return logic;
    }
    
    public List<Categoria> getCategorias(){
        try {
            return getLogic().buscar(null);
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
            return null;
        }
    }
    
}
