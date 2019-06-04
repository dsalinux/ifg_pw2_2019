package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.ProdutoDAO;
import br.edu.ifg.sistemacomercial.entity.Produto;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class ProdutoLogic implements GenericLogic<Produto, Integer> {

    @Inject
    private ProdutoDAO dao;
    
    @Override
    public Produto salvar(Produto entity) throws  NegocioException, SistemaException {
        if("".equals(entity.getNome().trim())){
            throw new NegocioException("Nome da categoria é obrigatório.");
        }
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Produto entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Produto buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Produto> buscar(Produto entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
