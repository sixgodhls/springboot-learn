package com.example.tushusys.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private Integer id;
    private String content;
    private LocalDateTime commentDate;
    private Book book;
    private String username;
}
