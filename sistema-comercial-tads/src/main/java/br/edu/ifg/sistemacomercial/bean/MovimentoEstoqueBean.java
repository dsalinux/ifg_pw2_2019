package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Produto;
import br.edu.ifg.sistemacomercial.entity.Fornecedor;
import br.edu.ifg.sistemacomercial.entity.MovimentoEstoque;
import br.edu.ifg.sistemacomercial.logic.FornecedorLogic;
import br.edu.ifg.sistemacomercial.logic.ProdutoLogic;
import br.edu.ifg.sistemacomercial.logic.MovimentoEstoqueLogic;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class MovimentoEstoqueBean extends GenericCrud<MovimentoEstoque, MovimentoEstoqueLogic>{
        
    @Inject
    private ProdutoLogic produtoLogic;
    @Inject
    private FornecedorLogic fornecedorLogic;
    @Inject
    private MovimentoEstoqueLogic logic;
    
    public List<Produto> getProdutos(){
        try {
            return produtoLogic.buscar(null);
        } catch (SistemaException ex) {
            addMensagemFatal(ex);
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        }
        return null;
    }
    public List<Fornecedor> getFornecedores(){
        try {
            return fornecedorLogic.buscar(null);
        } catch (SistemaException ex) {
            addMensagemFatal(ex);
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        }
        return null;
    }

    @Override
    public MovimentoEstoqueLogic getLogic() {
        return logic;
    }
}
