package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.PedidoDAO;
import br.edu.ifg.sistemacomercial.dao.PedidoHasProdutoDAO;
import br.edu.ifg.sistemacomercial.entity.Cliente;
import br.edu.ifg.sistemacomercial.entity.Endereco;
import br.edu.ifg.sistemacomercial.entity.Pedido;
import br.edu.ifg.sistemacomercial.entity.PedidoHasProduto;
import br.edu.ifg.sistemacomercial.entity.Usuario;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class PedidoLogic implements GenericLogic<Pedido, Integer> {

    @Inject
    private PedidoDAO dao;
    
    @Inject
    private PedidoHasProdutoDAO peidHasProdutoDAO;
    
    @Override
    public Pedido salvar(Pedido entity) throws  NegocioException, SistemaException {        
        if(entity.getId() == null){
            Usuario usuario = new Usuario();
            usuario.setId(2);
            entity.setUsuario(usuario);
        }
        List<PedidoHasProduto> listaPedidoProduto = entity.getPedidosHasProdutos();
        entity.setPedidosHasProdutos(null);
        entity = dao.salvar(entity);
        if(listaPedidoProduto != null && !listaPedidoProduto.isEmpty()){
            for (PedidoHasProduto pedidoProduto : listaPedidoProduto) {
                pedidoProduto.setPedido(entity);
                pedidoProduto = peidHasProdutoDAO.salvar(pedidoProduto);
            }
            entity.setPedidosHasProdutos(listaPedidoProduto);
        }
        return entity;
    }

    @Override
    public void deletar(Pedido entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Pedido buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Pedido> buscar(Pedido entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
