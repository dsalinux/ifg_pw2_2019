package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.CategoriaDAO;
import br.edu.ifg.sistemacomercial.entity.Categoria;
import java.util.List;
import javax.inject.Inject;

public class CategoriaLogic implements GenericLogic<Categoria, Integer> {

    @Inject
    private CategoriaDAO dao;
    
    @Override
    public Categoria salvar(Categoria entity) throws Exception {
        if("".equals(entity.getNome().trim())){
            throw new Exception("Nome da categoria é obrigatório.");
        }
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Categoria entity) throws Exception {
        dao.deletar(entity);
    }

    @Override
    public Categoria buscarPorId(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Categoria> buscar(Categoria entity) throws Exception {
        return dao.listar();
    }
    
}
