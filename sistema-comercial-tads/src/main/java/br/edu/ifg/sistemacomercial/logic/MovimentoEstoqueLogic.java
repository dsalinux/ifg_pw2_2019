package br.edu.ifg.sistemacomercial.logic;
import br.edu.ifg.sistemacomercial.dao.MovimentoEstoqueDAO;
import br.edu.ifg.sistemacomercial.entity.MovimentoEstoque;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class MovimentoEstoqueLogic implements GenericLogic<MovimentoEstoque, Integer> {

    @Inject
    private MovimentoEstoqueDAO dao;
    
    @Override
    public MovimentoEstoque salvar(MovimentoEstoque entity) throws  NegocioException, SistemaException {
        if((entity.getFornecedor() == null)){
            throw new NegocioException("Fornecedor é obrigatório.");
        }
        if(entity.getTipoMovimento() == null){
            throw new NegocioException("Tipo movimento é obrigatório.");
        }
        if((entity.getQuantidadeRecebida()==null)){
            throw new NegocioException("Quantidade recebida é obrigatório.");
        }
        if((entity.getPrecoCusto()==null)){
            throw new NegocioException("Preço custo é obrigatório.");
        }
     
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(MovimentoEstoque entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public MovimentoEstoque buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<MovimentoEstoque> buscar(MovimentoEstoque entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
}
