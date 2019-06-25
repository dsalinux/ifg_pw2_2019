package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Cliente;
import br.edu.ifg.sistemacomercial.entity.enums.EstadosEnum;
import br.edu.ifg.sistemacomercial.logic.ClienteLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ClienteBean extends GenericCrud<Cliente, ClienteLogic> {

    @Inject
    private ClienteLogic logic;

    private int tipoCliente;

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    @Override
    public ClienteLogic getLogic() {
        return logic;
    }

    public EstadosEnum[] getListaEstados() {
        return EstadosEnum.values();
    }

}
