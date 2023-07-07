package com.example.restfulapi.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BaseResult {
    private Integer code;
    private String msg;
}
