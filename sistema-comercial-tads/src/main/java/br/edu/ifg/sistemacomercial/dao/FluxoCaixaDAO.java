package br.edu.ifg.sistemacomercial.dao;

import br.edu.ifg.sistemacomercial.entity.FluxoCaixa;
import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;

public class FluxoCaixaDAO extends GenericDAO<FluxoCaixa, Integer>{
    public List<FluxoCaixa> buscarNoPeriodo(Date dataInicio, Date dataFim){
        List fluxos;
        fluxos = getEntityManager().createQuery("from "+getEntityClass().getName()+
                " f where f.dataMovimento between :dataInicio and :dataFim")
                .setParameter("dataInicio", dataInicio, TemporalType.DATE)
                .setParameter("dataFim", dataFim, TemporalType.DATE)
                .getResultList();
        return fluxos;
    }
}
