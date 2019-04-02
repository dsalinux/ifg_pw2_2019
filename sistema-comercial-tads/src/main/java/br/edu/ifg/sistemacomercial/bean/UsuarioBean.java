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
public class UsuarioBean {
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    private Status statusTela;
    
    private enum Status {
        INSERINDO,
        EDITANDO,
        PESQUISANDO
    }
    
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        usuarios = new ArrayList<>();   
        statusTela = Status.PESQUISANDO;
    }
    
    public void novo(){
        statusTela = Status.INSERINDO;
        usuario = new Usuario();
    }

    public void adicionarUsuario(){
        usuarios.add(usuario);
        usuario = new Usuario();
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(
                FacesMessage.SEVERITY_INFO, 
                "Adicionado com sucesso.", 
                "O usuário "+usuario.getNome()+" foi salvom com sucesso.");
        context.addMessage(null, fm);
        pesquisar();
    }
    
    public void remover(Usuario usuario){
        usuarios.remove(usuario);
    }
    public void editar(Usuario usuario){
        remover(usuario);
        this.usuario = usuario;
        statusTela = Status.EDITANDO;
    }
    
    public void pesquisar(){
        statusTela = Status.PESQUISANDO;
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

    public String getStatusTela() {
        return statusTela.name();
    }
    
}
