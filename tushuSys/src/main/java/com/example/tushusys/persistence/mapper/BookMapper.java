package com.example.tushusys.persistence.mapper;

import com.example.tushusys.persistence.entity.Book;
import com.example.tushusys.persistence.entity.BookDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface BookMapper {
    @Results(id="bookMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "imgUrl",column = "img"),
            @Result(property = "imgBigUrl",column = "img_big")
    })
    @Select("select id,title,author,price,discount,img,img_big,inventory from books where is_hot = 1 ")
    List<Book> findBookByHot();

    @ResultMap("bookMap")
    @Select("select id,title,author,price,discount,img,img_big,inventory from books where is_new = 1 ")
    List<Book> findBookByNew();

    @Results(id = "bookDetailMap",value = {
        @Result(id = true,property = "id",column = "id"),
        @Result(property = "imgUrl",column = "img"),
        @Result(property = "imgBigUrl",column = "img_big"),
        @Result(property = "newness",column = "is_new"),
        @Result(property = "hot",column = "is_hot"),
        @Result(property = "specialOffer",column = "is_special_offer"),
        @Result(property = "category",column = "category_id",
            one = @One(select = "com.example.tushusys.persistence.mapper.CategoryMapper.findById",fetchType = FetchType.EAGER)
        )
    }
    )
    @Select("select * from books where id=#{id}")
    BookDetail findById(int id);

    @ResultMap("bookMap")
    @Select("select id,title,author,price,discount,img,img_big,inventory,publish_date,book_concern,brief" +
            "from books where category_id = #{category_id}")
    List<Book> findCategoryBookByPage(int category_id,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    @ResultMap("bookMap")
    @Select("select id,title,author,price,discount,img,img_big,inventory,publish_date,book_concern,brief" +
            "from books where title like '%${keyword}%'")
    List<Book> findKeywordBooksByPage(String keyword, @Param("pageNum") int pageNum,@Param("pageSize") int pageSize);


}
