package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.PermissaoDAO;
import br.edu.ifg.sistemacomercial.entity.Permissao;
import br.edu.ifg.sistemacomercial.util.StringUtil;
import java.util.List;
import javax.inject.Inject;

public class PermissaoLogic implements GenericLogic<Permissao, Integer> {

    @Inject
    private PermissaoDAO dao;
    
    @Override
    public Permissao salvar(Permissao entity) throws Exception {
        if("".equals(entity.getNome().trim())){
            throw new Exception("Nome da permissão é obrigatório.");
        }
//        entity.setNome(StringUtil.replaceAllSpecialCharacters(entity.getNome()));
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(Permissao entity) throws Exception {
        dao.deletar(entity);
    }

    @Override
    public Permissao buscarPorId(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Permissao> buscar(Permissao entity) throws Exception {
        return dao.listar();
    }
    
}
