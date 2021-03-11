package com.nish.restdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.nish.restdemo.model.Books;
import com.nish.restdemo.repo.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    //getting all books record by using the method findaAll() of CrudRepository
    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        booksRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Books getBooksById(int id) {
        return booksRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Books books) {
        booksRepository.save(books);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    //updating a record
    public void update(Books books, int bookid) {
        booksRepository.save(books);
    }

}