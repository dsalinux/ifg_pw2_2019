package br.edu.ifg.hello.bean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AlunoBean {

    private String nome;
    private List<String> nomes = new ArrayList<>();
    
    public void adicionar(){
        nomes.add(nome);
        nome = "";
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<String> getNomes() {
        return nomes;
    }
    
}
