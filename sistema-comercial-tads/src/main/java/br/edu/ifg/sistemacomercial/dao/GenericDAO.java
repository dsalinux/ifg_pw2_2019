package br.edu.ifg.sistemacomercial.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GenericDAO<E> implements Serializable {
    
    @Inject
    private EntityManager entityManager;
    
    public E salvar(E entity) throws SQLException{
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
       return entity;
    }
    
    public void deletar(E entity) throws SQLException{
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
    
    public List<E> listar() throws SQLException{
        return entityManager.createQuery("from "+getEntityClass().getName()).getResultList();
    }
    public Class<E> getEntityClass() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        
        return (Class<E>) paramType.getActualTypeArguments()[0];        
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
