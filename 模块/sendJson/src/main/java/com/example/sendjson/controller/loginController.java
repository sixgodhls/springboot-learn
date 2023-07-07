package com.example.sendjson.controller;

import com.example.sendjson.persistence.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class loginController {
    @GetMapping
    public ModelAndView home(){

        return new ModelAndView("login.html");
    }

    @PostMapping(value = "/login",consumes = "application/json")
    @ResponseBody
    public void login(HttpServletResponse response, @RequestBody User user) throws IOException {
        PrintWriter writer = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        writer.print(json);
        System.out.println(user);
//        if (user.getUsername()=="aaa"){
//
//        }
    }
}
