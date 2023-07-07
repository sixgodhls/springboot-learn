package com.example.user_reg_login.controller.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult {
    private Integer Code;
    private String msg;
}
