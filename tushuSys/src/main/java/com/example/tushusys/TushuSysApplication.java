package com.example.tushusys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TushuSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(TushuSysApplication.class, args);
    }

}
