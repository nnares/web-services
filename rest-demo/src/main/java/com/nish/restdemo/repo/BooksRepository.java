package com.nish.restdemo.repo;

import com.nish.restdemo.model.Books;
import org.springframework.data.repository.CrudRepository;

//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Books, Integer> {
}