package com.csky.web;


import com.csky.domain.Category;
import com.csky.domain.School;
import com.csky.service.CategoryService;
import com.csky.service.SchoolService;
import com.csky.service.impl.CategoryServiceImpl;
import com.csky.service.impl.SchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 16105
 */
@WebServlet("/school/*")
public class SchoolServlet extends BaseServlet {
    private SchoolService service = new SchoolServiceImpl();

    /**
     * 查询所有分类
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAllSname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<School> list = service.getAllSname();
        System.out.println(list);
        writeValue(list, response);
    }

}
