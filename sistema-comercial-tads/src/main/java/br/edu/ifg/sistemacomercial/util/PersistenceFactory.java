package br.edu.ifg.sistemacomercial.util;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

public class PersistenceFactory {

    @Produces
    public EntityManager getEntityManager(){
        EntityManager entityManager;
                
        entityManager = Persistence
                .createEntityManagerFactory("sistema_comercial_tads_PU")
                .createEntityManager();

        
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/siscom", "postgres","ifg").load();
//        Flyway flyway = Flyway.configure().dataSource(
//                entityManager.getEntityManagerFactory().getProperties().get("javax.persistence.jdbc.url").toString(), 
//                entityManager.getEntityManagerFactory().getProperties().get("javax.persistence.jdbc.user").toString(),
//                entityManager.getEntityManagerFactory().getProperties().get("javax.persistence.jdbc.password").toString()).load();
        flyway.migrate();
        return entityManager;
    }
    
    public void close(@Disposes EntityManager entityManager){
        entityManager.close();
    }
}
