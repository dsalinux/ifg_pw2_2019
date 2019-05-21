package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.UsuarioDAO;
import br.edu.ifg.sistemacomercial.entity.Usuario;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class UsuarioLogic implements GenericLogic<Usuario, Integer> {

    @Inject
    private UsuarioDAO dao;
    
    @Override
    public Usuario salvar(Usuario entity) throws Exception {
        if("".equals(entity.getNome().trim())){
            throw new Exception("Nome do usuário é obrigatório.");
        }
        if(entity.getDataCadastro() == null){
            entity.setDataCadastro(new Date());
        }
        entity = dao.salvar(entity);
        return entity;
    }

    @Override
    public void deletar(Usuario entity) throws Exception {
        dao.deletar(entity);
    }

    @Override
    public Usuario buscarPorId(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> buscar(Usuario entity) throws Exception {
        List<Usuario> usuarios = dao.listar();
        return usuarios;
    }
    
}
