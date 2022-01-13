package com.csky.dao.impl;

import com.csky.dao.CategoryDao;
import com.csky.domain.Category;
import com.csky.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * @author 20121706
 */
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category;";
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
