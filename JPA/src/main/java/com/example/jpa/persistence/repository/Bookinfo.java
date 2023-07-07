package com.example.jpa.persistence.repository;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "bookinfo1")
public class Bookinfo {
  @Id
  @GeneratedValue(generator = "fr")
  @GenericGenerator(name = "fr",strategy = "foreign",
          parameters = @Parameter(name = "property",value = "books")
  )
  private long id;
  private String author;
  private String bookConcern;
  private String brief;
  private long inventory;
  private double price;
  private java.sql.Date publishDate;
  private String title;
  @OneToOne(optional = false)
  @PrimaryKeyJoinColumn
  private Books books;
}
