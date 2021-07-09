package com.terio.dao;

import com.terio.db.DBAccess;
import com.terio.entity.Message;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 和Message表相关的数据库操作
 */
public class MessageDao {
    /**
          根据查询条件来查询消息列表 (Mybatis）
    */
    public List<Message> queryMessageList(String command, String description) throws NullPointerException{
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            // 通过sqlSession执行SQL语句
            messageList = sqlSession.selectList("Message.queryMessageList", message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    /*
    *   单条删除
    * */
    public void deleteOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行SQL语句
            sqlSession.delete("Message.deleteOne", id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /*
     *   批量删除
     * */
    public void deleteBatch(List<Integer> ids) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行SQL语句
            sqlSession.delete("Message.deleteBatch", ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

/*
    *//*
    *    根据查询条件来查询消息列表 (传统写法）
    * *//*
    public List<Message> queryMessageList(String command, String description) throws Exception {
        List<Message> messageList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto_robot?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "1827365");
        System.out.println("connect the mysql success");
        StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");

        List<String> paramList = new ArrayList<>();
        if (command != null && !"".equals(command.trim())) {
            sql.append(" and COMMAND=?");
            paramList.add(command);
        }
        if (description != null && !"".equals(description.trim())) {
            sql.append(" and DESCRIPTION like '%' ? '%'");
            paramList.add(description);
        }

        PreparedStatement ps = conn.prepareStatement(sql.toString());
        for (int i = 0; i < paramList.size(); i++) {
            ps.setString(i+1, paramList.get(i));
        }
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Message message = new Message();
            messageList.add(message);
            message.setId(rs.getString("ID"));
            message.setCommand(rs.getString("COMMAND"));
            message.setDescription(rs.getString("DESCRIPTION"));
            message.setContent(rs.getString("CONTENT"));
            System.out.println(message.getId());
        }
        return messageList;
    }*/
}
