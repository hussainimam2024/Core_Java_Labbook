package com.example.book_hive_project.service;

import com.example.book_hive_project.model.BooksLogics;
import com.example.book_hive_project.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

    public boolean updateBookById(int id, BooksLogics updatedBook) {
        if (bookRepo.existsById(id)) {
            updatedBook.setId(id);
            bookRepo.save(updatedBook);
            return true;
        }
        return false;
    }

    public BooksLogics partialUpdateBookById(int id, Map<String, Object> updates) {
        BooksLogics book = getBookById(id);
        if (book != null) {
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(BooksLogics.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, book, value);
                }
            });
            return bookRepo.save(book);
        }
        return null;
    }

    public boolean deleteBookById(int id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<BooksLogics> getBooksByName(String bookName) {
        return bookRepo.findByBookNameContainingIgnoreCase(bookName);
    }

    public boolean deleteBooksByName(String bookName) {
        List<BooksLogics> books = bookRepo.findByBookNameContainingIgnoreCase(bookName);
        if (!books.isEmpty()) {
            bookRepo.deleteAll(books);
            return true;
        }
        return false;
    }

    public List<BooksLogics> getBooksByAuthorName(String authorName) {
        return bookRepo.findByAuthorNameContainingIgnoreCase(authorName);
    }

    public boolean deleteBooksByAuthorName(String authorName) {
        List<BooksLogics> books = bookRepo.findByAuthorNameContainingIgnoreCase(authorName);
        if (!books.isEmpty()) {
            bookRepo.deleteAll(books);
            return true;
        }
        return false;
    }

    public List<BooksLogics> getBooksByCategory(String category) {
        return bookRepo.findByCategoryContainingIgnoreCase(category);
    }

    public boolean deleteBooksByCategory(String category) {
        List<BooksLogics> books = bookRepo.findByCategoryContainingIgnoreCase(category);
        if (!books.isEmpty()) {
            bookRepo.deleteAll(books);
            return true;
        }
        return false;
    }

    public List<BooksLogics> getBooksByPrice(double price) {
        return bookRepo.findByPrice(price);
    }

    public BooksLogics updateBookPrice(int id, Map<String, Object> updates) {
        BooksLogics book = getBookById(id);
        if (book != null && updates.containsKey("price")) {
            book.setPrice((int) Double.parseDouble(updates.get("price").toString()));
            return bookRepo.save(book);
        }
        return null;
    }

    public boolean deleteBooksByPrice(double price) {
        List<BooksLogics> books = bookRepo.findByPrice(price);
        if (!books.isEmpty()) {
            bookRepo.deleteAll(books);
            return true;
        }
        return false;
    }
}
