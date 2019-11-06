package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Permissao;
import br.edu.ifg.sistemacomercial.entity.Usuario;
import br.edu.ifg.sistemacomercial.logic.PermissaoLogic;
import br.edu.ifg.sistemacomercial.logic.UsuarioLogic;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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
    
    public Usuario getLoggedUser(){
        Usuario usuario = null;
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof Usuario){
            usuario = (Usuario) user;
        }
        return usuario;
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
