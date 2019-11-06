package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.dao.UsuarioDAO;
import br.edu.ifg.sistemacomercial.entity.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
@SessionScoped
public class LoginBean implements Serializable{

    private Usuario usuarioLogado;
    private String email;
    private String senha;
    @Inject
    private UsuarioDAO usuarioDAO;

    public LoginBean() {
    }

      public String logIn() {
        usuarioLogado = usuarioDAO.buscar(email, senha);
        if (usuarioLogado == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválidos", "Login Inválido"));
            return null;
        } else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (session != null) {
                session.setAttribute("usuario", usuarioLogado);
            }
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String logOff() {
        SecurityContextHolder.clearContext();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/login.xhtml?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
}