package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.PermissaoDAO;
import br.edu.ifg.sistemacomercial.entity.Permissao;
import br.edu.ifg.sistemacomercial.util.StringUtil;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class PermissaoLogic implements GenericLogic<Permissao, Integer> {

    @Inject
    private PermissaoDAO dao;
    
    @Override
    public Permissao salvar(Permissao entity) throws  NegocioException, SistemaException {
        if("".equals(entity.getNome().trim())){
            throw new NegocioException("Nome da permissão é obrigatório.");
        }
//        entity.setNome(StringUtil.replaceAllSpecialCharacters(entity.getNome()));
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Permissao entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Permissao buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Permissao> buscar(Permissao entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
