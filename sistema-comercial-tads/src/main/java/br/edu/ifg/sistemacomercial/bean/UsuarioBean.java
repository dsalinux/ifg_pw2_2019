package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UsuarioBean {
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public void adicionarUsuario(){
        usuarios.add(usuario);
        usuario = new Usuario();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso.", "O usuário "+usuario.getNome()+" foi salvom com sucesso."));
    }
    
    public void remover(Usuario usuario){
        usuarios.remove(usuario);
    }
    public void editar(Usuario usuario){
        remover(usuario);
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
}
