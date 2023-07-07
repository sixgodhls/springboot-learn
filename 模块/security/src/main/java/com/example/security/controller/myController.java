package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping()
public class myController {
    @ResponseBody
    @GetMapping("/all")
    public String all(){
        return "all";
    }

    @GetMapping("/user1")
    public String user1(){
        return "user1";
    }

    @GetMapping("/user2")
    public String user2(){
        return "user2";
    }
}
