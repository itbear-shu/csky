package com.csky.dao.impl;

import com.csky.dao.SchoolDao;
import com.csky.domain.School;
import com.csky.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 20121706
 */
public class SchoolDaoImpl implements SchoolDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<School> getAllSname() {
        String sql = "select sname from school;";
        return template.query(sql, new BeanPropertyRowMapper<School>(School.class));
    }

}
