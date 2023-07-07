package com.example.esearch.persistence.repository;

import com.example.esearch.persistence.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    /**
     * 通过图书标题关键字模糊查询图书
     * @param title
     * @return
     */
    List<Book> findByTitleLike(String title);

    /**
     * 使用@Query注解自定义分页查询
     * @param title
     * @return
     */
    @Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")
    Page<Book> findByTitleCustom(String title, Pageable pageable);

}
