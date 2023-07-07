package com.example.jpa.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Bookinfo,Integer> {
}
