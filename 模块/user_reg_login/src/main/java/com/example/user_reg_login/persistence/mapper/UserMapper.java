package com.example.user_reg_login.persistence.mapper;

import com.example.user_reg_login.persistence.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where username=#{username}")
    User findUserByUsername(String username);

    @Insert("insert into t_user(username,password,salt) values(#{username},#{password},#{salt})")
    int insertUser(User user);
}
