package com.example.redis.service;

import com.example.redis.persistence.entity.Book;
import com.example.redis.persistence.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "book")
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    @Cacheable
    public Book getBookById(Integer id){
        System.out.println(id);
        return bookMapper.getBookById(id);
    }
    @CachePut(key = "#result.id")
    public Book saveBook(Book book){
        bookMapper.saveBook(book);
        return book;
    }
}
