package com.example.book_hive_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Bookstore")
public class BooksLogics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    private String authorName;
    private String category;
    private String publisher;
    private String publishedYear;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPublishedYear() {
        return publishedYear;
    }
    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }
}
/*
one url for post ,get, put, patch, delete
http://localhost:8080/books
 */