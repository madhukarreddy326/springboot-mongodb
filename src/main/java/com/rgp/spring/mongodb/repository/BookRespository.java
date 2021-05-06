package com.rgp.spring.mongodb.repository;

import com.rgp.spring.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRespository extends MongoRepository<Book,Integer> {
}
