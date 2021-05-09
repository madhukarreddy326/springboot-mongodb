package com.rgp.spring.mongodb.resource;

import com.rgp.spring.mongodb.model.Book;
import com.rgp.spring.mongodb.repository.BookRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRespository repository;
    @PostMapping("/book")
    public String saveBook(@RequestBody Book book)
    {
        logger.trace("this is from the saveBook method()");
        repository.save(book);
        return "success with the boookId :" +book.getId();
    }
    @GetMapping("/book")
    public List<Book> getBooks()
    {
        logger.trace("this is from the getBooks method()");
        return repository.findAll();
    }
    @GetMapping("/book/{id}")
    public Optional<Book> getBoook(@PathVariable int id)
    {
        logger.trace("this is from the single getBoook() method()");
        return repository.findById(id);
    }
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id)
    {
        logger.trace("this is from the deleteBook() method()");
        repository.deleteById(id);
        return "Deleted book with Id :"+id;
    }



}
