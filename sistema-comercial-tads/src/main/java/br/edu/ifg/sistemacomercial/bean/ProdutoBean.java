package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Categoria;
import br.edu.ifg.sistemacomercial.entity.Produto;
import br.edu.ifg.sistemacomercial.util.JsfUtil;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoBean extends JsfUtil{
    
    private Produto produto;
    private List<Categoria> categorias;
    
    public ProdutoBean() {
        Categoria c1 = new Categoria();
        c1.setId(1);
        c1.setNome("Higiene");
        Categoria c2 = new Categoria();
        c2.setId(2);
        c2.setNome("Limpeza");
        Categoria c3 = new Categoria();
        c3.setId(3);
        c3.setNome("Industrializado");
        
        categorias = Arrays.asList(c1,c2,c3);
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
    
}
