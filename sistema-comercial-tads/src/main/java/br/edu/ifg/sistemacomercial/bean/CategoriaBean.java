package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.dao.CategoriaDAO;
import br.edu.ifg.sistemacomercial.entity.Categoria;
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
public class CategoriaBean extends JsfUtil{
    
    private Categoria categoria;
    private List<Categoria> categorias;
    private Status statusTela;
    
    private CategoriaDAO categoriaDAO;
    
    private enum Status {
        INSERINDO,
        EDITANDO,
        PESQUISANDO
    }
    
    
    @PostConstruct
    public void init(){
        categoria = new Categoria();
        categorias = new ArrayList<>();   
        statusTela = Status.PESQUISANDO;
        categoriaDAO = new CategoriaDAO();
    }
    
    public void novo(){
        statusTela = Status.INSERINDO;
        categoria = new Categoria();
    }

    public void adicionarCategoria(){
        try {
            categoriaDAO.salvar(categoria);
            categoria = new Categoria();
            addMensagem("Salvo com sucesso!");
            pesquisar();
        } catch (SQLException ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public void remover(Categoria categoria){
        try {
            categoriaDAO.deletar(categoria);
            categorias.remove(categoria);
            addMensagem("Deletado com sucesso!");
        } catch (SQLException ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    public void editar(Categoria categoria){
        //remover(categoria);
        this.categoria = categoria;
        statusTela = Status.EDITANDO;
    }
    
    public void pesquisar(){
        try {
            if(!statusTela.equals(Status.PESQUISANDO)){
                statusTela = Status.PESQUISANDO;
                return;
            }
            categorias = categoriaDAO.listar();
            if(categorias == null || categorias.isEmpty()){
                addMensagemAviso("Nenhum usuário cadastrado.");
            }
        } catch (SQLException ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public String getStatusTela() {
        return statusTela.name();
    }
    
}
