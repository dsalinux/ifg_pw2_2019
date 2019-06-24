package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.PedidoHasProdutoDAO;
import br.edu.ifg.sistemacomercial.entity.PedidoHasProduto;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class PedidoHasProdutoLogic implements GenericLogic<PedidoHasProduto, Integer> {

    @Inject
    private PedidoHasProdutoDAO dao;
    
    @Override
    public PedidoHasProduto salvar(PedidoHasProduto entity) throws  NegocioException, SistemaException {
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(PedidoHasProduto entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public PedidoHasProduto buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<PedidoHasProduto> buscar(PedidoHasProduto entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }


    
}
