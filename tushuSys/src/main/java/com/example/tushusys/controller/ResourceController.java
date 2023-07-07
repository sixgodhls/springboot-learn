package com.example.tushusys.controller;

import com.example.tushusys.controller.result.BaseResult;
import com.example.tushusys.controller.result.DataResult;
import com.example.tushusys.persistence.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @GetMapping
    public ResponseEntity<BaseResult> getResource(){
        DataResult<String> userDataResult = new DataResult<String>();
        userDataResult.setData("resource");
        userDataResult.setMsg("Ok");
        userDataResult.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(userDataResult);
    }
}
