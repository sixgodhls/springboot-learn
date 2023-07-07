package com.example.jpa.persistence.repository;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
public class Books {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private String author;
  private String bookConcern;
  private java.sql.Date publishDate;
  private double price;
  private long categoryId;
  @OneToOne(mappedBy = "books",
  cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
  private Bookinfo bookinfo;




}
