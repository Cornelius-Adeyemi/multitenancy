package com.adebisi.multitenantDemo.access_stored_procedure;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoredEntity {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void createSchema(String schemaName){
       entityManager.createNativeQuery("CALL create_schema_and_tables(:schemaName)")
               .setParameter("schemaName", schemaName)
               .executeUpdate();

    }
}
