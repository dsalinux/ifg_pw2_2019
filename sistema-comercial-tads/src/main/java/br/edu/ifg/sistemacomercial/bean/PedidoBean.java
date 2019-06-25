package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Cliente;
import br.edu.ifg.sistemacomercial.entity.Pedido;
import br.edu.ifg.sistemacomercial.entity.PedidoHasProduto;
import br.edu.ifg.sistemacomercial.entity.Produto;
import br.edu.ifg.sistemacomercial.logic.ClienteLogic;
import br.edu.ifg.sistemacomercial.logic.EnderecoLogic;
import br.edu.ifg.sistemacomercial.logic.PedidoLogic;
import br.edu.ifg.sistemacomercial.logic.ProdutoLogic;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PedidoBean extends GenericCrud<Pedido, PedidoLogic>{

    @Inject
    private PedidoLogic logic;

    @Inject
    private ProdutoLogic produtoLogic;
    
    @Inject
    private ClienteLogic clienteLogic;
    
    private PedidoHasProduto pedidoHasProduto = new PedidoHasProduto();
    
    @Inject
    private EnderecoLogic enderecoLogic;
    
    public void novoPedidoHasProduto(){
        pedidoHasProduto = new PedidoHasProduto();
    }
    
    public void deletarPedidoHasProduto(PedidoHasProduto pedidoHasProduto){
        getEntity().getPedidosHasProdutos().remove(pedidoHasProduto);
    }
    
    public void adicionarProduto(){
        if(getEntity().getPedidosHasProdutos() == null){
            getEntity().setPedidosHasProdutos(new ArrayList<PedidoHasProduto>());
        }
        if(!getEntity().getPedidosHasProdutos().contains(pedidoHasProduto)){
            getEntity().getPedidosHasProdutos().add(pedidoHasProduto);
        }
        novoPedidoHasProduto();
    }


    
    @Override
    public PedidoLogic getLogic() {
        return logic;
    }
    
    public List<Produto> getProdutos(){
        try {
            return produtoLogic.buscar(null);
        } catch (NegocioException ex){
            addMensagemErro(ex);
        }catch(SistemaException ex) {
            addMensagemFatal(ex);
        }
        return null;
    }
    
        public void ativarCancelar(Pedido pedido){
        try {
            if(pedido.getDataCancelamento()== null){
                pedido.setDataCancelamento(new Date());
            } else {
                pedido.setDataCancelamento(null);
            }
            pedido = getLogic().salvar(pedido);
        } catch (NegocioException ex) {
            addMensagemErro(ex.getMessage());
        } catch(SistemaException ex){
            addMensagemFatal(ex);
        }
    }
    
    public List<Cliente> getClientes(){
        try {
            return clienteLogic.buscar(null);
        } catch (NegocioException ex){
            addMensagemErro(ex);
        }catch(SistemaException ex) {
            addMensagemFatal(ex);
        }
        return null;
    }    
    
    public PedidoHasProduto getPedidoHasProduto() {
        return pedidoHasProduto;
    }
    
}
