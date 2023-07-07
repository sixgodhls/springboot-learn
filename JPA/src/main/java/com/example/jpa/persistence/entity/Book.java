package com.example.jpa.persistence.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@ToString
@Entity
@Table(name = "bookinfo")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100,nullable = false)
    private String title;
    @Column(length = 100,nullable = false)
    private String author;
    @Column(length = 100,nullable = false)
    private String bookConcern;
    @Column(length = 100,nullable = false)
    private LocalDate publishDate;
    @Column(columnDefinition = "decimal(6,2)")
    private Float price;
    @Column(length = 100,nullable = false)
    private Integer inventory;
    @Column(length = 100,nullable = false)
    private String brief;
}
