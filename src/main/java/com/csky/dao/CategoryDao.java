package com.csky.dao;



import com.csky.domain.Category;

import java.util.List;

/**
 * Category的数据库访问接口
 * @author 16105
 */
public interface CategoryDao {

    /**
     * 返回tab_category中的所有数据
     * @return List
     */
    List<Category> findAll();
}
