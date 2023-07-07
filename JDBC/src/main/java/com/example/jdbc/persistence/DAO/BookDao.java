package com.example.jdbc.persistence.DAO;


import com.example.jdbc.persistence.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 新增一本图书
    public Book saveBook(Book book) {
        String sql = "insert into books(title, author, book_concern, publish_date, price, category_id) values(?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection conn) -> {
            PreparedStatement ps =
                    conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getBookConcern());
            ps.setDate(4, book.getPublishDate());
            ps.setFloat(5, book.getPrice());
            ps.setInt(6, book.getCategoryId());
            return ps;
        }, keyHolder);
        book.setId(keyHolder.getKey().intValue());
        return book;
    }
}