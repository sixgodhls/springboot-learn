package com.example.tushusys.controller;

import com.example.tushusys.controller.result.BaseResult;
import com.example.tushusys.persistence.entity.User;
import com.example.tushusys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final String DEFAULT_ROLE = "ROLE_USER";
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<BaseResult> register(@RequestBody User user){
        user.setRoles(DEFAULT_ROLE);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.register(user);
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(HttpStatus.OK.value());
        baseResult.setMsg("OK");
        return ResponseEntity.ok(baseResult);
    }
}
