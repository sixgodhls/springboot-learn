package com.example.jdbc.persistence.DAO;


import com.example.jdbc.incrementer.MaxValueIncrementer;
import com.example.jdbc.persistence.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MaxValueIncrementer maxValueIncrementer;

    // 新增一个分类
    public Category saveCategory(Category category) {
        String sql = "insert into category(id, name, root, parent_id) values (?, ?, ?, ?)";
        int id = maxValueIncrementer.getNextValue("category");
        jdbcTemplate.update(sql, (PreparedStatement ps) -> {
            ps.setInt(1, id);
            ps.setString(2, category.getName());
            ps.setBoolean(3, category.getRoot());
            ps.setInt(4, category.getParentId());
        });
        return category;
    }

    // 更新一个分类
    public Category updateCategory(Category category) {
        String sql = "update category set name = ?, root = ?, parent_id = ? where id = ?";
        jdbcTemplate.update(sql, category.getName(), category.getRoot(),
                category.getParentId(), category.getId());
        return category;
    }

    // 删除一个分类
    public void deleteCategory(int id) {
        String sql = "delete from category where id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * 内部类，将结果集的行映射为Category对象
     */
    private class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category  = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setRoot(rs.getBoolean("root"));
            Object parentId = rs.getObject("parent_id");
            if(parentId == null)
                category.setParentId(null);
            else
                category.setParentId((Integer)parentId);
            return category;
        }
    }
    // 根据分类ID查询一个分类
    public Category getCategoryById(int id) {
        String sql = "select * from category where id = ?";
        Category cat = jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
        return cat;
    }

    // 获取所有分类
    public List<Category> getAllCategories() {
        String sql = "select * from category";
        List<Category> categories = jdbcTemplate.query(sql, new CategoryRowMapper());
        return categories;
    }
}