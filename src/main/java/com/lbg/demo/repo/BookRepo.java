package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
