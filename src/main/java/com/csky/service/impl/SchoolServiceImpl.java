package com.csky.service.impl;

import com.csky.dao.SchoolDao;
import com.csky.dao.impl.SchoolDaoImpl;
import com.csky.domain.School;
import com.csky.service.SchoolService;

import java.util.List;

/**
 * @author 20121706
 */
public class SchoolServiceImpl implements SchoolService {
    public SchoolDao schoolDao = new SchoolDaoImpl();

    @Override
    public List<School> getAllSname() {
        return schoolDao.getAllSname();
    }
}
