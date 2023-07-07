package com.example.restfulapi.controller;

import com.example.restfulapi.result.BaseResult;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GlobalErrorController implements ErrorController {
    private static final String ERROR_PATH="/error";

    @RequestMapping(ERROR_PATH)
    public ResponseEntity<BaseResult> error(HttpServletResponse response){
        int code = response.getStatus();
        BaseResult result = null;
        switch (code){
            case 401:
                result = new BaseResult(401,"用户未登录");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
            case 403:
                result = new BaseResult(
                        403, "没有访问权限");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
            case 404:
                result = new BaseResult(
                        404, "请求的资源不存在");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
            case 405:
                result = new BaseResult(
                        405, "请求方法对指定的资源不可用");
                return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(result);
            case 500:
                result = new BaseResult(
                        500, "服务端错误");
            default:
                result = new BaseResult(
                        500, "未知错误");
                return ResponseEntity.status(
                        HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }
}
