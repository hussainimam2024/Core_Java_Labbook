package com.example.book_hive_project.repo;

import com.example.book_hive_project.model.BooksLogics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<BooksLogics, Integer> {

    List<BooksLogics> findByBookNameContainingIgnoreCase(String bookName);

    List<BooksLogics> findByAuthorNameContainingIgnoreCase(String authorName);

    List<BooksLogics> findByCategoryContainingIgnoreCase(String category);

    List<BooksLogics> findByPrice(double price);
}
