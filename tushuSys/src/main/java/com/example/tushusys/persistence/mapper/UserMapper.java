package com.example.tushusys.persistence.mapper;

import com.example.tushusys.persistence.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into users(username,password,mobile,roles) " +
            "values(#{username},#{password},#{mobile},#{roles})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveUser(User user);

    @Select("select * from users where username = #{username}")
    User findUserByUsername(String username);

    @Select("select * from users where mobile = #{mobile}")
    User findUserByMobile(String mobile);
}
