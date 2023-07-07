package com.example.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

@SpringBootTest
class JdbcApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testStatementCallback() {
        jdbcTemplate.execute((Statement stmt) -> {
            String sql = "insert into category(id, name, root, parent_id) values (3, 'Java EE', 1, null)";
            return stmt.executeUpdate(sql);
        });
    }

}
