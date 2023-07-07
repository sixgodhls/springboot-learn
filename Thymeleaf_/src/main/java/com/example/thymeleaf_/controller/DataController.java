package com.example.thymeleaf_.controller;

import com.example.thymeleaf_.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DataController {
    @GetMapping({"/","/index"})
    public String home(Model model, HttpServletRequest request, HttpSession session){

        Employee emp1=new Employee(1,"zs",22,5000f, LocalDate.of(2020,4,20), Arrays.asList("Java","C"));
        Employee emp2=new Employee(2,"ls",23,5200f, LocalDate.of(2023,2,22), Arrays.asList("Java","C#"));
        Employee emp3=new Employee(3,"w5",33,5900f, LocalDate.of(2013,1,22), Arrays.asList("Java","C#","Python"));
        List<Employee> emps=new ArrayList<>();

        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);

        model.addAttribute("message","all in");
        model.addAttribute("emps",emps);

        request.setAttribute("foo","requestAttr");
        session.setAttribute("user",emp1);
        request.getServletContext().setAttribute("foo","applicationAttr");

        return "home";
    }
}
