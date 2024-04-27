package com.lbg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Book;
import com.lbg.demo.repo.BookRepo;

@Service
public class BookService {

	private BookRepo repo;

	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Book> createBook(Book newBook) {
		Book created = this.repo.save(newBook);
		return new ResponseEntity<Book>(created, HttpStatus.CREATED);
	}

	public List<Book> getBook() {
		return this.repo.findAll();
	}

	public ResponseEntity<Book> getBook(Integer id) {
		Optional<Book> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Book body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Book> updateBook(Integer id, Book BookDetails) {
		Optional<Book> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		Book existing = found.get();

		if (BookDetails.getName() != null) {
			existing.setName(BookDetails.getName());
		}
		if (BookDetails.getAuthor() != null) {
			existing.setAuthor(BookDetails.getAuthor());

		}
		if (BookDetails.getImage() != null) {
			existing.setImage(BookDetails.getImage());
		}

		Book updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean removeBook(Integer id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}