package com.lbg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Note;
import com.lbg.demo.repo.NoteRepo;

@Service
public class NoteService {

	private NoteRepo repo;

	public NoteService(NoteRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Note> createNote(Note newNote) {
		Note created = this.repo.save(newNote);
		return new ResponseEntity<Note>(created, HttpStatus.CREATED);
	}

	public List<Note> getNote() {
		return this.repo.findAll();
	}

	public ResponseEntity<Note> getNote(Integer id) {
		Optional<Note> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Note body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Note> updateNote(Integer id, Note NoteDetails) {
		Optional<Note> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
		}

		Note existing = found.get();

		if (NoteDetails.getTitle() != null) {
			existing.setTitle(NoteDetails.getTitle());
		}
		if (NoteDetails.getText() != null) {
			existing.setText(NoteDetails.getText());

		}

		Note updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean removeNote(Integer id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}
