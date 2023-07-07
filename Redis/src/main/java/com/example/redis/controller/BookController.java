package com.example.redis.controller;

import com.example.redis.persistence.entity.Book;
import com.example.redis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public String saveBook(@RequestBody Book book){
        return bookService.saveBook(book).toString();
    }
    @GetMapping("/{id}")
    public String getBookById(@PathVariable Integer id){
        return bookService.getBookById(id).toString();
    }
}
