package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.CategoriaDAO;
import br.edu.ifg.sistemacomercial.entity.Categoria;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class CategoriaLogic implements GenericLogic<Categoria, Integer> {

    @Inject
    private CategoriaDAO dao;
    
    @Override
    public Categoria salvar(Categoria entity) throws  NegocioException, SistemaException {
        if("".equals(entity.getNome().trim())){
            throw new NegocioException("Nome da categoria é obrigatório.");
        }
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Categoria entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Categoria buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Categoria> buscar(Categoria entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
