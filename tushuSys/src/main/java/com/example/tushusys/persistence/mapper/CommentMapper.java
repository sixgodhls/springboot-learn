package com.example.tushusys.persistence.mapper;

import com.example.tushusys.persistence.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select id,content,comment_date,username from comment where book_id = #{book_id}")
    List<Comment> findCommentByBookId(int book_id);
}
