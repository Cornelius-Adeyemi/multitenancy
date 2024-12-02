package com.adebisi.multitenantDemo.repository;

import com.adebisi.multitenantDemo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BooksRepo extends JpaRepository<Books, UUID> {


}
