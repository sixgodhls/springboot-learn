package com.example.esearch.persistence.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@ToString
@Document(indexName = "book")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String bookConcern;
    private Date publishDate;
    private Float price;
}
