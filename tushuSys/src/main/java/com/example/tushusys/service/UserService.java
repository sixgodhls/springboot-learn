package com.example.tushusys.service;

import com.example.tushusys.persistence.entity.User;
import com.example.tushusys.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        User user = userMapper.findUserByUsername(token);
        if (user == null){
            user = userMapper.findUserByMobile(token);
            if (user == null){
                throw new UsernameNotFoundException("user not exist");
            }
        }
        return user;
    }

    public User register(User user){
        userMapper.saveUser(user);
        return user;
    }
}
