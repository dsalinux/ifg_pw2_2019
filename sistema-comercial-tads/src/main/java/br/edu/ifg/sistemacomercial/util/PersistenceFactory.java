package br.edu.ifg.sistemacomercial.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;

@ApplicationScoped
public class PersistenceFactory {

    Flyway flyway;
    
    public EntityManagerFactory emf(){
        return Persistence.createEntityManagerFactory("sistema_comercial_tads_PU");
    }
    
    @Bean
    @Produces
    public EntityManager getEntityManager(){
        EntityManager entityManager;
                
        entityManager = emf().createEntityManager();

        
//        if(flyway == null){
//            this.flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/siscom", "root","ifg").load();
//            flyway.migrate();
//        }
//        Flyway flyway = Flyway.configure().dataSource(
//                entityManager.getEntityManagerFactory().getProperties().get("javax.persistence.jdbc.url").toString(), 
//                entityManager.getEntityManagerFactory().getProperties().get("javax.persistence.jdbc.user").toString(),
//                entityManager.getEntityManagerFactory().getProperties().get("javax.persistence.jdbc.password").toString()).load();
        return entityManager;
    }
    
    public void close(EntityManager entityManager){
        entityManager.close();
    }
}
