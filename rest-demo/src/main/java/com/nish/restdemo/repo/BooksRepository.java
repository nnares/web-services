package com.nish.restdemo.repo;

import com.nish.restdemo.model.Books;
import org.springframework.data.repository.CrudRepository;

// https://www.javatpoint.com/spring-boot-crud-operations
//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Books, Integer> {
}