package com.example.jpa;

import com.example.jpa.persistence.entity.Book;
import com.example.jpa.persistence.repository.BookRepository;
import com.example.jpa.persistence.repository.Bookinfo;
import com.example.jpa.persistence.repository.Books;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private BookRepository bookRepository;
    @Test
    void saveBook(){
        Books book = new Books();
        book.setTitle("222");
        book.setAuthor("222");
        book.setBookConcern("222");
        book.setPrice(222.f);
        book.setCategoryId(53);
        book.setPublishDate(new Date(123512512));
        Bookinfo bookinfo = new Bookinfo();
        bookinfo.setBookConcern("333");
        bookinfo.setAuthor("333");
        bookinfo.setBrief("333");
        bookinfo.setPrice(222.f);
        Date date = new Date(123512512);
        bookinfo.setPublishDate(date);

        book.setBookinfo(bookinfo);
        bookinfo.setBooks(book);
        bookRepository.save(bookinfo);

    }
//    @Test
//    void updateBook(){
//        Optional<Book> byId = bookRepository.findById(1);
//        if (byId.isPresent()){
//            Book book = byId.get();
//            book.setBookConcern("222");
//            bookRepository.save(book);
//        }
//    }
}
