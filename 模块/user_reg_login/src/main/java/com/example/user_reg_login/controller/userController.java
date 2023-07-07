package com.example.user_reg_login.controller;

import com.example.user_reg_login.controller.result.BaseResult;
import com.example.user_reg_login.controller.result.DataResult;
import com.example.user_reg_login.persistence.entity.BaseUser;
import com.example.user_reg_login.persistence.entity.User;
import com.example.user_reg_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userService;
    @GetMapping("/{username}")
    public ResponseEntity<BaseResult> findUserByUsername(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        DataResult result = new DataResult();
        result.setData(user.toString());
        result.setCode(HttpServletResponse.SC_OK);
        result.setMsg("请求成功");
        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<BaseResult> registerUser(@RequestBody BaseUser baseUser){
        User user = new User();
        user.setUsername(baseUser.getUsername());
        user.setPassword(baseUser.getPassword());
        user.setSalt(UUID.randomUUID().toString());
        userService.registerUser(user);
        DataResult result = new DataResult();
        result.setData(user.toString());
        result.setCode(HttpServletResponse.SC_OK);
        result.setMsg("请求成功");
        return ResponseEntity.ok(result);
    }

}
