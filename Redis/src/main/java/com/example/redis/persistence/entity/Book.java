package com.example.redis.persistence.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Date;

@Data
@ToString

public class Book implements Serializable {
    private Long id;
    private String title;
    private String author;
    private String bookConcern;
    private Date publishDate;
    private Double price;
}
