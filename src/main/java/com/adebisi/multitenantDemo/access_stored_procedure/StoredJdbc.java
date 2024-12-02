package com.adebisi.multitenantDemo.access_stored_procedure;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StoredJdbc {


    private final JdbcTemplate jdbcTemplate;

    public StoredJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createSchema(String schemaName){

        String sql = "CALL public.create_schema_and_tables(?)";
        jdbcTemplate.update(sql, schemaName);
    }
}
