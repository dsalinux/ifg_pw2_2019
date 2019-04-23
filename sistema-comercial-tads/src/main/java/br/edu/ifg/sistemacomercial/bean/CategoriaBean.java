package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Categoria;
import br.edu.ifg.sistemacomercial.logic.CategoriaLogic;
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
    
}
