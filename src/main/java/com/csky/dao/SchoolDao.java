package com.csky.dao;

import com.csky.domain.School;

import java.util.List;

/**
 * @author 20121706
 */
public interface SchoolDao {
    /**
     * 获取所有学习名称
     * @return list
     */
    List<School> getAllSname();
}
