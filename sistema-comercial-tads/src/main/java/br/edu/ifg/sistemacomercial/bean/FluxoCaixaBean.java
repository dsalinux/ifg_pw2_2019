package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Conta;
//import br.edu.ifg.sistemacomercial.entity.Pedido;
import br.edu.ifg.sistemacomercial.entity.FluxoCaixa;
import br.edu.ifg.sistemacomercial.entity.TipoMovimento;
import br.edu.ifg.sistemacomercial.logic.ContaLogic;
//import br.edu.ifg.sistemacomercial.logic.PedidoLogic;
import br.edu.ifg.sistemacomercial.logic.FluxoCaixaLogic;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FluxoCaixaBean extends GenericCrud<FluxoCaixa, FluxoCaixaLogic> {

    @Inject
    private ContaLogic contaLogic;
    @Inject
    private FluxoCaixaLogic logic;
    private Date dataInicio;
    private Date dataFim;

    @Override
    public void pesquisar() {
        
        try {
            if(!getStatus().equals(GenericCrud.Status.PESQUISANDO)){
                setStatus(GenericCrud.Status.PESQUISANDO);
                return;
            }
            setEntitys(logic.buscarNoPeriodo(dataInicio, dataFim));
            if(getEntitys() == null || getEntitys().isEmpty()){
                addMensagemAviso("Nenhum registro cadastrado.");
            }
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        } catch(SistemaException ex){
            addMensagemFatal(ex);
        }
    }

    public Double getTotalEntrada() {

        Double total = 0D;
        for (FluxoCaixa entity : getEntitys()) {
            if (TipoMovimento.ENTRADA.equals(entity.getTipoMovimento())) {
                total += entity.getValor();
            }
        }

        return total;
    }

    public Double getTotalSaida() {
        Double total = 0D;

        for (FluxoCaixa entity : getEntitys()) {
            if (TipoMovimento.SAÍDA.equals(entity.getTipoMovimento())) {
                total += entity.getValor();
            }
        }

        return total;

    }

    public Double getResumo() {
        return getTotalEntrada() - getTotalSaida();
    }

    public List<Conta> getContas() {
        try {
            return contaLogic.buscar(null);
        } catch (SistemaException ex) {
            addMensagemFatal(ex);
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        }
        return null;
    }

    @Override
    public FluxoCaixaLogic getLogic() {
        return logic;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    public SelectItem[] getTiposMovimento() {

        SelectItem[] items = new SelectItem[TipoMovimento.values().length];
        int i = 0;
        for (TipoMovimento t : TipoMovimento.values()) {
            items[i++] = new SelectItem(t, t.getNome());
        }
        return items;
    }

}
