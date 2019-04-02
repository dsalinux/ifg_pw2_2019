package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.dao.UsuarioDAO;
import br.edu.ifg.sistemacomercial.entity.Usuario;
import br.edu.ifg.sistemacomercial.util.JsfUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean extends JsfUtil{
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    private Status statusTela;
    
    private UsuarioDAO usuarioDAO;
    
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
        usuarioDAO = new UsuarioDAO();
    }
    
    public void novo(){
        statusTela = Status.INSERINDO;
        usuario = new Usuario();
    }

    public void adicionarUsuario(){
        try {
            usuarioDAO.salvar(usuario);
            usuario = new Usuario();
            addMensagem("Salvo com sucesso!");
            pesquisar();
        } catch (SQLException ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public void remover(Usuario usuario){
        try {
            usuarioDAO.deletar(usuario);
            usuarios.remove(usuario);
            addMensagem("Deletado com sucesso!");
        } catch (SQLException ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    public void editar(Usuario usuario){
        //remover(usuario);
        this.usuario = usuario;
        statusTela = Status.EDITANDO;
    }
    
    public void pesquisar(){
        try {
            if(!statusTela.equals(Status.PESQUISANDO)){
                statusTela = Status.PESQUISANDO;
                return;
            }
            usuarios = usuarioDAO.listar();
            if(usuarios == null || usuarios.isEmpty()){
                addMensagemAviso("Nenhum usuário cadastrado.");
            }
        } catch (SQLException ex) {
            addMensagemErro(ex.getMessage());
        }
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
