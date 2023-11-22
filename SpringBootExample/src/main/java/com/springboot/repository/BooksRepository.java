package com.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Book;

@Repository
public interface BooksRepository extends MongoRepository<Book,Integer>{

}
