package com.nish.restdemo;

import java.util.Iterator;
import java.util.List;

import com.nish.restdemo.model.Books;
import com.nish.restdemo.repo.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
*
* https://www.javaguides.net/2019/06/spring-boot-crudrepository-example-tutorial.html
* Tester Bean class for CrudRepository<Books, Integer> feature
* Can test all the CrudRepository supported methods directly
*
* */
@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public void run(String...args) {

        booksRepository.save(new Books(5433, "Core and Advance Java", "R. Nageswara Rao", 800));
        booksRepository.save(new Books(5982,"Programming with Java", "E. Balagurusamy", 350));
        booksRepository.save(new Books(6321,"Data Structures and Algorithms in Java", "R. Nageswara Rao", 590));
        booksRepository.save(new Books(6830,"Effective Java", "Joshua Bloch", 670));
        booksRepository.save(new Books(9999,"Concurrency In Practice", "Brian Goetz", 1200));

        logger.info("# of books : {}", booksRepository.count());

        logger.info("All Books unsorted:");

        Iterable<Books> employees = booksRepository.findAll();
        for (Books employee : employees) {
            logger.info("{}", employee.toString());
        }

        logger.info("------------------------");

        logger.info("Deleting books with id 5433");
        booksRepository.deleteById(5433);

        logger.info("# of books : {}", booksRepository.count());

        if(booksRepository.existsById(6830)){
            logger.info("Book with id 6830 - {}", booksRepository.findById(6830).orElse(null));
        }

    }
}