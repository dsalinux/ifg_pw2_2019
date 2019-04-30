package br.edu.ifg.sistemacomercial.util;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PersistenceFactory {

    @Produces
    public EntityManager getEntityManager(){
        EntityManager entityManager;
                
        entityManager = Persistence
                .createEntityManagerFactory("sistema_comercial_tads_PU")
                .createEntityManager();
        
        return entityManager;
    }
    
    public void close(@Disposes EntityManager entityManager){
        entityManager.close();
    }
}
