package com.example.tushusys.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDetail extends Book{
    private String detail;
    private Boolean newness;
    private Boolean hot;
    private Boolean specialOffer;
    private String slogan;
    private Category category;
}
