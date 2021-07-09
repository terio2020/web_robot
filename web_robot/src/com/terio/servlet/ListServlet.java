package com.terio.servlet;

import com.terio.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Terto_MY on 2021-07-07 10:28
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("List Service...................................");
        // 设置编码，防止中文乱码
        req.setCharacterEncoding("UTF-8");
        // 接受页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        // 向页面传值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        // 查询消息列表并传给页面
        QueryService queryService = new QueryService();
        try {
            req.setAttribute("messageList", queryService.queryMessageList(command, description));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 向页面跳转
        System.out.println("send message");
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
