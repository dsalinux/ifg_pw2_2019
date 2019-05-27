package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Usuario;
import br.edu.ifg.sistemacomercial.logic.UsuarioLogic;
import java.util.Date;
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
    
    private String senha;

    @Override
    public void salvar() {
        if(senha != null && !"".equals(senha.trim())){
            getEntity().setSenha(senha);
        }
        super.salvar();
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
    
    
    @Override
    public UsuarioLogic getLogic() {
        return logic;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
