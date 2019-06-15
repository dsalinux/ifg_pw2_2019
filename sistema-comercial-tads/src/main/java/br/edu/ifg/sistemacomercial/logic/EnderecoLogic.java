package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.EnderecoDAO;
import br.edu.ifg.sistemacomercial.entity.Endereco;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class EnderecoLogic implements GenericLogic<Endereco, Integer> {

    @Inject
    private EnderecoDAO dao;
    
    @Override
    public Endereco salvar(Endereco entity) throws  NegocioException, SistemaException {
        if("".equals(entity.getLogradouro().trim())){
            throw new NegocioException("Logradouro é obrigatório.");
        }
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Endereco entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Endereco buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Endereco> buscar(Endereco entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
