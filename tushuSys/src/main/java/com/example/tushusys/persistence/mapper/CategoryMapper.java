package com.example.tushusys.persistence.mapper;

import com.example.tushusys.persistence.entity.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Results(id="categoryMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "children",column = "id",many = @Many(select = "findChildrenByParentId",
            fetchType = FetchType.EAGER))
    })
    @Select("select * from category where root = 1")
    List<Category> findAll();

    @ResultMap("categoryMap")
    @Select("select * from category where parent_id = #{parentId}")
    List<Category> findChildrenByParentId(int parentId);

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "parentId", column = "parent_id")
    })
    @Select("select id,name,root,parent_id from category where id = #{id}")
    Category findById(int id);
}
