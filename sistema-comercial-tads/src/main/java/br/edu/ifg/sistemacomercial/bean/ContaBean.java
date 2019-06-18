package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Conta;
import br.edu.ifg.sistemacomercial.logic.ContaLogic;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ContaBean extends GenericCrud<Conta, ContaLogic>{

    @Inject
    private ContaLogic logic;
    
    @Override
    public ContaLogic getLogic() {
        return logic;
    }
    
    
    
}
