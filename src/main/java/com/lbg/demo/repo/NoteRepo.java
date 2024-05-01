package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Note;

public interface NoteRepo extends JpaRepository<Note, Integer> {

}
