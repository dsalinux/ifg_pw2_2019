package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Permissao;
import br.edu.ifg.sistemacomercial.entity.Usuario;
import br.edu.ifg.sistemacomercial.logic.PermissaoLogic;
import br.edu.ifg.sistemacomercial.logic.UsuarioLogic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioBean extends GenericCrud<Usuario, UsuarioLogic>{

    @Inject
    private UsuarioLogic logic;
    
    @Inject
    private PermissaoLogic permissaoLogic;
    
    private String senha;

    @Override
    public void salvar() {
        if(senha != null && !"".equals(senha.trim())){
            getEntity().setSenha(senha);
        }
        super.salvar();
    }

    @Override
    public void editar(Usuario entity) {
        try {
            entity = getLogic().buscarPorId(entity.getId());
            super.editar(entity);
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    
    public void ativarDesativar(Usuario usuario){
        try {
            if(usuario.getDataDesativacao() == null){
                usuario.setDataDesativacao(new Date());
            } else {
                usuario.setDataDesativacao(null);
            }
            usuario = getLogic().salvar(usuario);
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public List<Permissao> getPermissoes(){
        try {
            return getPermissaoLogic().buscar(null);
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public UsuarioLogic getLogic() {
        return logic;
    }

    public PermissaoLogic getPermissaoLogic() {
        return permissaoLogic;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
