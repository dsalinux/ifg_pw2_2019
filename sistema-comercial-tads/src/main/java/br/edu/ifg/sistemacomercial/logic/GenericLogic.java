package br.edu.ifg.sistemacomercial.logic;

import java.io.Serializable;
import java.util.List;

public interface GenericLogic<E, ID extends Serializable> extends Serializable{
    
    E salvar(E entity) throws Exception;
    void deletar(E entity) throws Exception;
    
    E buscarPorId(ID id) throws Exception;
    List<E> buscar(E entity) throws Exception;
    
}
