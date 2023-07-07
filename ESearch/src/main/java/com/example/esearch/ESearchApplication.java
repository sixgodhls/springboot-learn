package com.example.esearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class ESearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ESearchApplication.class, args);
    }

}
