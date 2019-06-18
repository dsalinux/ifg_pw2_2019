package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Cliente;
import br.edu.ifg.sistemacomercial.entity.Endereco;
import br.edu.ifg.sistemacomercial.logic.ClienteLogic;
import br.edu.ifg.sistemacomercial.logic.EnderecoLogic;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class EnderecoBean extends GenericCrud<Endereco, EnderecoLogic>{
        
    @Inject
    private ClienteLogic clienteLogic;
    @Inject
    private EnderecoLogic logic;
    public List<Cliente> getClientes(){
        try {
            return clienteLogic.buscar(null);
        } catch (SistemaException ex) {
            addMensagemFatal(ex);
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        }
        return null;
    }
    @Override
    public EnderecoLogic getLogic() {
        return logic;
    }
}
