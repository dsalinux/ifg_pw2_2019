package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    private Long codigo = 1L;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        usuarios = new ArrayList<>();   
    }

    public void adicionarUsuario(){
        usuario.setId(codigo++);
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
