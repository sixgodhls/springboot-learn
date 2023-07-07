package com.example.tushusys.service;

import com.example.tushusys.persistence.entity.Category;
import com.example.tushusys.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> getAllCategories(){
        return categoryMapper.findAll();
    }
    public List<Category> getChildrenByParentId(int parentId){
        return categoryMapper.findChildrenByParentId(parentId);
    }
    public Category getById(int id){
        return categoryMapper.findById(id);
    }

}
