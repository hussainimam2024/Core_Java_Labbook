package com.example.book_hive_project.service;

import com.example.book_hive_project.model.BooksLogics;
import com.example.book_hive_project.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public BooksLogics addBook(BooksLogics book) {
        return bookRepo.save(book);
    }

    public List<BooksLogics> getAllBooks() {
        return bookRepo.findAll();
    }

    public BooksLogics getBookById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public BooksLogics updateBook(int id, BooksLogics updatedBook) {
        BooksLogics existingBook = bookRepo.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setBookName(updatedBook.getBookName());
            existingBook.setAuthorName(updatedBook.getAuthorName());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setPublisher(updatedBook.getPublisher());
            existingBook.setPublishedYear(updatedBook.getPublishedYear());
            return bookRepo.save(existingBook);
        }
        return null;
    }
    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
}
