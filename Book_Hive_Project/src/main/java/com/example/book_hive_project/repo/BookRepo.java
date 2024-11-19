package com.example.book_hive_project.repo;

import com.example.book_hive_project.model.BooksLogics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BooksLogics, Integer> {

}

//public abstract class BookRepo implements BookRepo1 {
//    private JdbcTemplate jdbcTemplate;
//
//    public Object save(BooksLogics book) {
//        String sql = "INSERT INTO Bookstore (id, Book_name, author_name, Category, Publisher, published_year) VALUES (?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.update(sql, book.getId(), book.getBookName(), book.getAuthorName(), book.getCategory(), book.getPublisher(), book.getPublishedYear());
//        return null;
//    }
//
//    public List<BooksLogics> findAll() {
//        String sql = "SELECT * FROM Bookstore";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            BooksLogics book = new BooksLogics();
//            book.setId(rs.getInt("id"));
//            book.setBookName(rs.getString("Book_name"));
//            book.setAuthorName(rs.getString("author_name"));
//            book.setCategory(rs.getString("Category"));
//            book.setPublisher(rs.getString("Publisher"));
//            book.setPublishedYear(rs.getString("published_year"));
//            return book;
//        });
//    }
//}
