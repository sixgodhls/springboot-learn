package com.example.tushusys.controller;

import com.example.tushusys.controller.result.BaseResult;
import com.example.tushusys.controller.result.DataResult;
import com.example.tushusys.controller.result.PaginationResult;
import com.example.tushusys.persistence.entity.Book;
import com.example.tushusys.persistence.entity.BookDetail;
import com.example.tushusys.service.BookService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResult> getBook(@PathVariable int id){
        BookDetail book = bookService.getBook(id);
        if(book != null){
            DataResult<Book> bookDataResult = new DataResult<>();
            bookDataResult.setData(book);
            bookDataResult.setMsg("OK");
            bookDataResult.setCode(HttpStatus.OK.value());
            return ResponseEntity.ok(bookDataResult);
        }else{
            BaseResult baseResult = new BaseResult();
            baseResult.setMsg("Filed");
            baseResult.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(baseResult);
        }
    }

    @GetMapping("/hot")
    public ResponseEntity<BaseResult> getBookByHot(){
        List<Book> booksByHot = bookService.getBooksByHot();
        DataResult<List<Book>> listDataResult = new DataResult<>();
        listDataResult.setCode(HttpStatus.OK.value());
        listDataResult.setData(booksByHot);
        listDataResult.setMsg("Ok");
        return ResponseEntity.ok(listDataResult);
    }

    @GetMapping("/new")
    public ResponseEntity<BaseResult> getBookByNew(){
        List<Book> booksByHot = bookService.getBookByNew();
        DataResult<List<Book>> listDataResult = new DataResult<>();
        listDataResult.setCode(HttpStatus.OK.value());
        listDataResult.setData(booksByHot);
        listDataResult.setMsg("Ok");
        return ResponseEntity.ok(listDataResult);
    }
    private void translateBookImgUrl(List<Book> books){
        for(Book book : books) {
            book.setImgUrl(getServerInfo() + "/img/" + book.getImgUrl());
            book.setImgBigUrl(getServerInfo() + "/img/"  + book.getImgBigUrl());
        }
    }

    private String getServerInfo() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
        StringBuffer stringBuffer = new StringBuffer();
        HttpServletRequest request = requestAttributes1.getRequest();
        stringBuffer.append(request);
        return stringBuffer.toString();
    }

    private ResponseEntity<BaseResult> getPaginationResult(List<Book> books) {
        long total = ((Page) books).getTotal();
        translateBookImgUrl(books);
        PaginationResult<List<Book>> result = new PaginationResult<List<Book>>();
        result.setCode(HttpStatus.OK.value());
        result.setMsg("成功");
        result.setData(books);
        result.setTotal(total);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<BaseResult> getCategoryById(@PathVariable int id, @RequestParam int pageNum,@RequestParam int pageSize){
        List<Book> categoryBookByPage = bookService.getCategoryBookByPage(id, pageNum, pageSize);
        return getPaginationResult(categoryBookByPage);
    }
}
