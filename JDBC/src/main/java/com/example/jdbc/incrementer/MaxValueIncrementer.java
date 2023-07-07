package com.example.jdbc.incrementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MaxValueIncrementer {
    // 数据源
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //保存所有表序列值的表名
    @Value("${incrementer.tableName}")
    private String tableName;
    //保存表名的字段名
    @Value("${incrementer.tableColumnName}")
    private String tableColumnName;
    //保存序列值的字段名
    @Value("${incrementer.valueColumnName}")
    private String valueColumnName;

    /**
     * 得到参数queryTableName指定的表名的下一个序列值
     * @param queryTableName 查询哪一张表序列值的表名。
     * @return 下一个序列值
     */
    public int getNextValue(String queryTableName) {
        String sqlQuery = "select " + valueColumnName + " from "
                + tableName + " where " + tableColumnName
                + " = '" + queryTableName + "' for update";

        Integer id = jdbcTemplate.queryForObject(sqlQuery, Integer.class);
        if(id == null)
            id = 0;
        id++;
        String sqlUpdate = "update " + tableName + " set " + valueColumnName
                + " = " + id + " where " + tableColumnName + " = " + "'"
                + queryTableName + "'";

        jdbcTemplate.update(sqlUpdate);
        return id;
    }
}
