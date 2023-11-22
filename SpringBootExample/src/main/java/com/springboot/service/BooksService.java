package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Book;
import com.springboot.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	public List<Book> getAllBooks() {
		return booksRepository.findAll();
	}

	public Book getBooksById(int id) {
		return booksRepository.findById(id).get();
	}
    
	public Book addBook(Book book) {
		return booksRepository.insert(book);
	}

	
	public void Update(Book book) {
		booksRepository.save(book);
	}

	public void delete(int id) {
		booksRepository.deleteById(id);
	}

}
