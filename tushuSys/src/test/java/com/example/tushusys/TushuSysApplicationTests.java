package com.example.tushusys;

import com.example.tushusys.persistence.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TushuSysApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void test(){
        System.out.println(categoryMapper.findAll());
    }
    @Test
    public void testId(){
        System.out.println(categoryMapper.findById(9));
    }
}
