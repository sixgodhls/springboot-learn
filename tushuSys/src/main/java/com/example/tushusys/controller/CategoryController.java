package com.example.tushusys.controller;

import com.example.tushusys.controller.result.BaseResult;
import com.example.tushusys.controller.result.DataResult;
import com.example.tushusys.persistence.entity.Category;
import com.example.tushusys.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<BaseResult> getAllCategory(){
        List<Category> categories = categoryService.getAllCategories();
        DataResult<List<Category>> categoryDataResult = new DataResult<>();
        categoryDataResult.setData(categories);
        categoryDataResult.setMsg("OK");
        categoryDataResult.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(categoryDataResult);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BaseResult> getCategoryById(@PathVariable int id){
        Category category = categoryService.getById(id);
        if(category != null){
        DataResult<Category> categoryDataResult = new DataResult<>();
        categoryDataResult.setData(category);
        categoryDataResult.setMsg("OK");
        categoryDataResult.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(categoryDataResult);
        }else{
            BaseResult baseResult = new BaseResult();
            baseResult.setMsg("BadRequest");
            baseResult.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(baseResult);
        }

    }

    @GetMapping("/parent/{id}")
    public ResponseEntity<BaseResult> getChildrenByParent(@PathVariable int id){
        List<Category> childrenByParentId = categoryService.getChildrenByParentId(id);
        if(childrenByParentId != null){
            DataResult<List<Category>> listDataResult = new DataResult<>();
            listDataResult.setCode(HttpStatus.OK.value());
            listDataResult.setData(childrenByParentId);
            listDataResult.setMsg("OK");
            return ResponseEntity.ok(listDataResult);
        }else{
            BaseResult baseResult = new BaseResult();
            baseResult.setCode(HttpStatus.BAD_REQUEST.value());
            baseResult.setMsg("BadRequest");
            return ResponseEntity.badRequest().body(baseResult);
        }
    }
}
