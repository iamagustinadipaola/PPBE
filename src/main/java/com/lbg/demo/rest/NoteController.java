package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Note;
import com.lbg.demo.service.NoteService;

@RestController
@RequestMapping("/notes")
@CrossOrigin
public class NoteController {
	private NoteService service;

	public NoteController(NoteService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Note> createNote(@RequestBody Note newNote) {
		return this.service.createNote(newNote);
	}

	@GetMapping("/get")
	public List<Note> getNote() {
		return this.service.getNote();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Note> getNote(@PathVariable int id) {
		return this.service.getNote(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean removeNote(@PathVariable int id) {
		return this.service.removeNote(id);
	}

}