package com.example.thymeleaf_.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Employee {
    private Integer no;
    private String name;
    private Integer age;
    private Float salary;
    private LocalDate hireDate;
    private List<String> skills;

}
