package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Permissao;
import br.edu.ifg.sistemacomercial.logic.PermissaoLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PermissaoBean extends GenericCrud<Permissao, PermissaoLogic>{

    @Inject
    private PermissaoLogic logic;
    
    @Override
    public PermissaoLogic getLogic() {
        return logic;
    }
    
}
