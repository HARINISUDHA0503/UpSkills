package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Book;
import com.springboot.service.BooksService;

@RestController
@RequestMapping("/book")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return booksService.getAllBooks();		
	}
	
	@GetMapping("/{id}")  
	public Book getBooksById(@PathVariable int id) {
		return booksService.getBooksById(id);
	}
	
	@PostMapping("/addbook")  
	public Book addBook(@RequestBody Book book) {
		return booksService.addBook(book);
	}
	
	@PutMapping("/updatebook")  
	public void Update(@RequestBody Book book) {
		booksService.Update(book);;
	}

	@DeleteMapping("/deletebook/{id}")
	public void delete(@PathVariable("id") int id) {
		booksService.delete(id);;
	}
}
