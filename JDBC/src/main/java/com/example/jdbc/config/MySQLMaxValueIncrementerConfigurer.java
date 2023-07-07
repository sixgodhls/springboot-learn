package com.example.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

import javax.sql.DataSource;

@Configuration
public class MySQLMaxValueIncrementerConfigurer {
    @Bean
    public DataFieldMaxValueIncrementer dataFieldMaxValueIncrementer (
            @Autowired DataSource dataSource,
            @Value("${incrementer.incrementerName}") String incrementerName,
            @Value("${incrementer.columnName}") String columnName) {

        MySQLMaxValueIncrementer mySQLMaxValueIncrementer
                = new MySQLMaxValueIncrementer();
        // 设置数据源
        mySQLMaxValueIncrementer.setDataSource(dataSource);
        // 序列表的名字
        mySQLMaxValueIncrementer.setIncrementerName(incrementerName);
        // 序列表中保存序列值的字段名
        mySQLMaxValueIncrementer.setColumnName(columnName);
        return mySQLMaxValueIncrementer;
    }
}
