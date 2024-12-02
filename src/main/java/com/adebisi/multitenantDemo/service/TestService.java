package com.adebisi.multitenantDemo.service;


import com.adebisi.multitenantDemo.access_stored_procedure.StoredEntity;
import com.adebisi.multitenantDemo.access_stored_procedure.StoredJdbc;
import com.adebisi.multitenantDemo.model.Books;
import com.adebisi.multitenantDemo.repository.BooksRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final StoredJdbc storedJdbc;

    private final StoredEntity storedEntity;

    private final BooksRepo booksRepo;


    public String createSchemaAndTables(String schemaName){
        log.info("---------------schema name: {}", schemaName);
        storedJdbc.createSchema(schemaName);
        return "done";
    }


    public String saveBook(List<Books> books){
        booksRepo.saveAll(books);

        return "DONE";
    }


    public List<Books> findAllBooks(){

        return booksRepo.findAll();

    }
}
