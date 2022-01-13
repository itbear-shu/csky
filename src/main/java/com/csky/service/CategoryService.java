package com.csky.service;


import com.csky.domain.Category;

import java.util.List;

/**
 * @author 16105
 */
public interface CategoryService {
    /**
     * 返回tab_category中的所有数据
     * @return List
     */
    List<Category> findAll();
}
