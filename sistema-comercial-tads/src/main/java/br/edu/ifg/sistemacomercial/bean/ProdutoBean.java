package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Categoria;
import br.edu.ifg.sistemacomercial.entity.Produto;
import br.edu.ifg.sistemacomercial.logic.CategoriaLogic;
import br.edu.ifg.sistemacomercial.logic.ProdutoLogic;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProdutoBean extends GenericCrud<Produto, ProdutoLogic>{
        
    @Inject
    private CategoriaLogic categoriaLogic;
    @Inject
    private ProdutoLogic logic;
    
    public List<Categoria> getCategorias(){
        try {
            return categoriaLogic.buscar(null);
        } catch (SistemaException ex) {
            addMensagemFatal(ex);
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        }
        return null;
    }

    @Override
    public ProdutoLogic getLogic() {
        return logic;
    }
}
