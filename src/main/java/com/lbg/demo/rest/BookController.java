package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Book;
import com.lbg.demo.service.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin

public class BookController {

	private BookService service;

	public BookController(BookService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
		return this.service.createBook(newBook);
	}

	@GetMapping("/get")
	public List<Book> getBook() {
		return this.service.getBook();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		return this.service.getBook(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean removeBook(@PathVariable int id) {
		return this.service.removeBook(id);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book newBook) {
		return this.service.updateBook(id, newBook);
	}

}
