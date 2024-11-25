package com.example.book_hive_project.repository;

import com.example.book_hive_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(String category);
    List<Book> findByAuthor(String author);
}
