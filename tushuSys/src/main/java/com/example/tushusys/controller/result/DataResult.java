package com.example.tushusys.controller.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> extends BaseResult{
    private T data;
}
