package com.rgp.spring.mongodb.resource;

import com.rgp.spring.mongodb.model.Book;
import com.rgp.spring.mongodb.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRespository repository;
    @PostMapping("/book")
    public String saveBook(@RequestBody Book book)
    {
        repository.save(book);
        return "success with the boookId :" +book.getId();
    }
    @GetMapping("/book")
    public List<Book> getBooks()
    {
        return repository.findAll();
    }
    @GetMapping("/book/{id}")
    public Optional<Book> getBoook(@PathVariable int id)
    {
        return repository.findById(id);
    }
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id)
    {
        repository.deleteById(id);
        return "Deleted book with Id :"+id;
    }



}
