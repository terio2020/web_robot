package com.terio.servlet;

import com.terio.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除单条的控制层
 */
public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("DeleteOne  Service...................................");
        // 设置编码，防止中文乱码
        req.setCharacterEncoding("UTF-8");
        // 接受页面的值
        String id = req.getParameter("id");
        MaintainService maintainService = new MaintainService();
        maintainService.deleteOne(id);
        // 向页面跳转
        System.out.println("send message");
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
