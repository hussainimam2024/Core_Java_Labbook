package com.example.book_hive_project.controller;



import com.example.book_hive_project.model.BooksLogics;
import com.example.book_hive_project.repo.BookRepo;
import com.example.book_hive_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepo bookRepo;

    @PostMapping
    public ResponseEntity<BooksLogics> createBook(@RequestBody BooksLogics book) {
        BooksLogics savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }
    @GetMapping
    public ResponseEntity<List<BooksLogics>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BooksLogics> getBookById(@PathVariable int id) {
        BooksLogics book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        System.out.println("Book not found");
        return ResponseEntity.notFound().build();

    }

    //put is used to replace all the fields
    @PutMapping("/{id}")
    public ResponseEntity<BooksLogics> updateBook(@PathVariable int id, @RequestBody BooksLogics updatedBook) {
        BooksLogics updated = bookService.updateBook(id, updatedBook);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<BooksLogics> partialUpdateBook(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        BooksLogics existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            return ResponseEntity.notFound().build();
        }

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(BooksLogics.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingBook, value);
            }
        });

        BooksLogics updatedBook = bookService.addBook(existingBook);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

}
