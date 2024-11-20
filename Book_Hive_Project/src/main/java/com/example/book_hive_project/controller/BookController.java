package com.example.book_hive_project.controller;

import com.example.book_hive_project.model.BooksLogics;
import com.example.book_hive_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // POST: Add a new book
    @PostMapping
    public ResponseEntity<BooksLogics> createBook(@RequestBody BooksLogics book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    // GET: Retrieve all books
    @GetMapping
    public ResponseEntity<List<BooksLogics>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // HTTP methods for ID
    @GetMapping("/{id}")
    public ResponseEntity<BooksLogics> getBookById(@PathVariable int id) {
        return bookService.getBookById(id) != null ?
                ResponseEntity.ok(bookService.getBookById(id)) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BooksLogics> updateBookById(@PathVariable int id, @RequestBody BooksLogics updatedBook) {
        return bookService.updateBookById(id, updatedBook) ?
                ResponseEntity.ok(updatedBook) :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BooksLogics> patchBookById(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        BooksLogics book = bookService.partialUpdateBookById(id, updates);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        return bookService.deleteBookById(id) ?
                ResponseEntity.ok("Book deleted successfully") :
                ResponseEntity.badRequest().body("Book not found");
    }

    // HTTP methods for Book Name
    @GetMapping("/name/{bookName}")
    public ResponseEntity<List<BooksLogics>> getBooksByName(@PathVariable String bookName) {
        return ResponseEntity.ok(bookService.getBooksByName(bookName));
    }

    @DeleteMapping("/name/{bookName}")
    public ResponseEntity<String> deleteBooksByName(@PathVariable String bookName) {
        return bookService.deleteBooksByName(bookName) ?
                ResponseEntity.ok("Books with name '" + bookName + "' deleted successfully.") :
                ResponseEntity.badRequest().body("No books found with name '" + bookName + "'");
    }

    // HTTP methods for Author Name
    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<BooksLogics>> getBooksByAuthor(@PathVariable String authorName) {
        return ResponseEntity.ok(bookService.getBooksByAuthorName(authorName));
    }

    @DeleteMapping("/author/{authorName}")
    public ResponseEntity<String> deleteBooksByAuthor(@PathVariable String authorName) {
        return bookService.deleteBooksByAuthorName(authorName) ?
                ResponseEntity.ok("Books by author '" + authorName + "' deleted successfully.") :
                ResponseEntity.badRequest().body("No books found by author '" + authorName + "'");
    }

    // HTTP methods for Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<BooksLogics>> getBooksByCategory(@PathVariable String category) {
        return ResponseEntity.ok(bookService.getBooksByCategory(category));
    }

    @DeleteMapping("/category/{category}")
    public ResponseEntity<String> deleteBooksByCategory(@PathVariable String category) {
        return bookService.deleteBooksByCategory(category) ?
                ResponseEntity.ok("Books in category '" + category + "' deleted successfully.") :
                ResponseEntity.badRequest().body("No books found in category '" + category + "'");
    }

    // HTTP methods for Price
    @GetMapping("/price/{price}")
    public ResponseEntity<List<BooksLogics>> getBooksByPrice(@PathVariable double price) {
        return ResponseEntity.ok(bookService.getBooksByPrice(price));
    }

    @PutMapping("/price/{id}")
    public ResponseEntity<BooksLogics> updateBookPrice(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        BooksLogics updatedBook = bookService.updateBookPrice(id, updates);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/price/{price}")
    public ResponseEntity<String> deleteBooksByPrice(@PathVariable double price) {
        return bookService.deleteBooksByPrice(price) ?
                ResponseEntity.ok("Books with price " + price + " deleted successfully.") :
                ResponseEntity.badRequest().body("No books found with price " + price);
    }
}
