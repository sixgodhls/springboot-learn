package com.example.tushusys.service;

import com.example.tushusys.persistence.entity.Book;
import com.example.tushusys.persistence.entity.BookDetail;
import com.example.tushusys.persistence.entity.Comment;
import com.example.tushusys.persistence.mapper.BookMapper;
import com.example.tushusys.persistence.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CommentMapper commentMapper;

    public Book getBookById(int id){
        return bookMapper.findById(id);
    }

    public List<Book> getBooksByHot(){
        return bookMapper.findBookByHot();
    }

    public List<Book> getBookByNew(){
        return bookMapper.findBookByHot();
    }

    public BookDetail getBook(int id){
        return bookMapper.findById(id);
    }

    public List<Book> getCategoryBookByPage(int categoryId,int pageNum,int pageSize){
        return bookMapper.findCategoryBookByPage(categoryId, pageNum, pageSize);
    }

    public List<Book> getKeywordBooksByPage(String keyWord,int pageNum,int pageSize){
        return bookMapper.findKeywordBooksByPage(keyWord,pageNum,pageSize);
    }

    public List<Comment> getCommentsByBookId(int bookId){
        return commentMapper.findCommentByBookId(bookId);
    }
}
