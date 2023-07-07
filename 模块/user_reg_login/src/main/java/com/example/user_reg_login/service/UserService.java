package com.example.user_reg_login.service;

import com.example.user_reg_login.persistence.entity.User;
import com.example.user_reg_login.persistence.mapper.UserMapper;
import com.example.user_reg_login.service.ex.BadInsert;
import com.example.user_reg_login.service.ex.UserAlreadyExists;
import com.example.user_reg_login.service.ex.UserNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserByUsername(String username){
        User user = userMapper.findUserByUsername(username);
        if(user == null){
            throw new UserNotExists("用户不存在");
        }
        return user;
    }
    public int registerUser(User user){
        User userCheck = userMapper.findUserByUsername(user.getUsername());
        if(userCheck != null){
            throw new UserAlreadyExists("用户已存在");
        }
        int i = userMapper.insertUser(user);
        if (i == 0){
            throw new BadInsert("插入不成功");
        }
        return i;
    }
}
