package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.ClienteDAO;
import br.edu.ifg.sistemacomercial.entity.Cliente;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class ClienteLogic implements GenericLogic<Cliente, Integer> {

    @Inject
    private ClienteDAO dao;
    
    @Override
    public Cliente salvar(Cliente entity) throws  NegocioException, SistemaException {
        if("".equals(entity.getNome().trim())){
            throw new NegocioException("Nome do Cliente é obrigatório.");
        }
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Cliente entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Cliente buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Cliente> buscar(Cliente entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
