package com.example.tushusys.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Float price;
    private Float discount;
    private String bookConcern;
    private String imgUrl;
    private String imgBigUrl;
    private LocalDate publishDate;
    private String brief;
    private Integer inventory;
}
