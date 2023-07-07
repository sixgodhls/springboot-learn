package com.example.tushusys.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Category {
    private Integer id;
    private String name;
    private Boolean root;
    private Integer parentId;
    private List<Category> children;
}
