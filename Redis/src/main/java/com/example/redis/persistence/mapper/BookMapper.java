package com.example.redis.persistence.mapper;

import com.example.redis.persistence.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
    @Select("select * from books where id=#{id}")
    Book getBookById(int id);

    @Insert("insert into books(title,author,book_concern,publish_date,price)"
            +"values(#{title},#{author},#{bookConcern},#{publishDate},#{price})"
    )
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveBook(Book book);
}
