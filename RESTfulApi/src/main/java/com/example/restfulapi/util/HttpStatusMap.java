package com.example.restfulapi.util;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class HttpStatusMap {
    private static Map<HttpStatus,Integer> map=new HashMap<>();
    static {
        map.put(HttpStatus.OK,200);
        map.put(HttpStatus.NOT_FOUND,404);
    }
    public static Integer get(HttpStatus status){
        return map.get(status);
    }
}
