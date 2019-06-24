package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.FluxoCaixaDAO;
import br.edu.ifg.sistemacomercial.entity.FluxoCaixa;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class FluxoCaixaLogic implements GenericLogic<FluxoCaixa, Integer> {

    @Inject
    private FluxoCaixaDAO dao;
    
    @Override
    public FluxoCaixa salvar(FluxoCaixa entity) throws  NegocioException, SistemaException {
        if("".equals(entity.getDescricao().trim())){
            throw new NegocioException("Descrição é obrigatória.");
        }
        
        if(!(entity.getValor()!=null)){
            throw new NegocioException("Valor é obrigatório.");
        }
        
        if(entity.getTipoMovimento()==null){
            throw new NegocioException("Movimento é obrigatório.");
        }
        
        if((entity.getConta()==null)){
            throw new NegocioException("Tipo de conta é obrigatório");
        }
        
        
        
        dao.salvar(entity);
        return null;
    }

    @Override
    public void deletar(FluxoCaixa entity) throws  NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public FluxoCaixa buscarPorId(Integer id) throws  NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<FluxoCaixa> buscar(FluxoCaixa entity) throws  NegocioException, SistemaException {
        return dao.listar();
    }
    
    public List<FluxoCaixa> buscarNoPeriodo(Date dataInicio, Date dataFim) throws  NegocioException, SistemaException {
        if(dataInicio==null){
            throw new NegocioException("Informe a data de início!");
        }
        if(dataFim==null){
            throw new NegocioException("Informe a data final!");
        }
        return dao.buscarNoPeriodo(dataInicio, dataFim);
    }
}
