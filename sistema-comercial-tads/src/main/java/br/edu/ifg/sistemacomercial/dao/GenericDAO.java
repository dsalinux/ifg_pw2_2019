package br.edu.ifg.sistemacomercial.dao;

import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDAO<E, ID extends Serializable> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public E salvar(E entity) throws SistemaException {
        try {
            entityManager.getTransaction().begin();
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return entity;
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new SistemaException("Erro ao salvar " + getEntityClass().getName(), ex);
        }
    }

    public void deletar(E entity) throws SistemaException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new SistemaException("Erro ao deletar " + getEntityClass().getName(), ex);
        }
    }

    public List<E> listar() throws SistemaException {
        try {
            return entityManager.createQuery("from " + getEntityClass().getName()).getResultList();
        } catch (Exception ex) {
            throw new SistemaException("Erro ao listar " + getEntityClass().getName(), ex);
        }
    }

    public E buscarPorId(ID id) throws SistemaException {
        try {
        return entityManager.find(getEntityClass(), id);
        } catch (Exception ex) {
            throw new SistemaException("Erro ao buscar o " + getEntityClass().getName() + " com ID = "+id, ex);
        }
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
