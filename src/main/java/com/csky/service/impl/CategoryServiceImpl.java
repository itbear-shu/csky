package com.csky.service.impl;

import com.csky.dao.CategoryDao;
import com.csky.dao.impl.CategoryDaoImpl;
import com.csky.domain.Category;
import com.csky.service.CategoryService;
import com.csky.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 16105
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //1 从redis中查询
        //1.1 获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //1.2 使用sortedset排序查询
        Set<Tuple> set = jedis.zrangeWithScores("category", 0, -1);
        List<Category> list = null;
        //2 判断集合是否为空
        if (set.isEmpty()) {
            //3 如果为空，则需要从数据库查询并保存
            list = categoryDao.findAll();
            for (int i = 0; i < list.size(); i++) {
                jedis.zadd("category", list.get(i).getCid(), list.get(i).getCname());
            }
        } else {
            //4 如果不为空，则将缓存转为category列表
            list = new ArrayList<Category>();
            for (Tuple tuple : set) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                list.add(category);
            }
        }
        return list;
    }
}
