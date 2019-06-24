package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.ContaDAO;
import br.edu.ifg.sistemacomercial.entity.Conta;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class ContaLogic implements GenericLogic<Conta, Integer> {

    @Inject
    private ContaDAO dao;
    
    @Override
    public Conta salvar(Conta entity) throws  NegocioException, SistemaException {
        if("".equals(entity.getNome().trim())){
            throw new NegocioException("Nome da conta é obrigatório.");
        }
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Conta entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Conta buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Conta> buscar(Conta entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
