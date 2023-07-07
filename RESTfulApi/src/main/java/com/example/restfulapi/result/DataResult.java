package com.example.restfulapi.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> extends BaseResult {
    private T data;
}
