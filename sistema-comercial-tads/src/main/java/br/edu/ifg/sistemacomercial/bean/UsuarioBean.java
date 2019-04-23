package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Usuario;
import br.edu.ifg.sistemacomercial.logic.UsuarioLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioBean extends GenericCrud<Usuario, UsuarioLogic>{

    @Inject
    private UsuarioLogic logic;
    
    @Override
    public UsuarioLogic getLogic() {
        return logic;
    }
    
    
}
