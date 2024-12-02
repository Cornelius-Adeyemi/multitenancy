package com.adebisi.multitenantDemo.controller;


import com.adebisi.multitenantDemo.config.ContextHolder;
import com.adebisi.multitenantDemo.model.Books;
import com.adebisi.multitenantDemo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {


    private final TestService testService;



    @GetMapping("/get/{tenantId}")
    public String test(@PathVariable(name = "tenantId") String tenantId){

       return testService.createSchemaAndTables(tenantId);

    }

    @PostMapping("/save")
    public String saveBooks(@RequestBody List<Books> booksList){

        return testService.saveBook(booksList);

    }


    @GetMapping("/")
    public List<Books> findAllBooks(){

        return testService.findAllBooks();
    }



}
