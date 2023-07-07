package com.example.user_reg_login.persistence.entity;

import lombok.Data;

@Data
public class User extends BaseUser{

    private String salt;
}
