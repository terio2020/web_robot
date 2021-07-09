package com.terio.service;

import com.terio.dao.CommandDao;
import com.terio.dao.MessageDao;
import com.terio.entity.Command;
import com.terio.entity.CommandContent;
import com.terio.entity.Message;
import com.terio.util.Iconst;

import java.util.List;
import java.util.Random;

/**
 *   列表相关的业务功能
 */
public class QueryService {
    public List<Message> queryMessageList(String command,String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command, description);
    }

    /**
     * 通过指令查询自动回复的内容
     * @param command 指令
     * @return 自动回复的内容
     */
    public String queryByCommand(String command) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList;
        if(Iconst.HELP_COMMAND.equals(command)) {
            commandList = commandDao.queryCommandList(null,null);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < commandList.size(); i++) {
                if(i != 0) {
                    result.append("<br/>");
                }
                result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
            }
            return result.toString();
        }
        commandList = commandDao.queryCommandList(command, null);
        if(commandList.size() > 0) {
            List<CommandContent> contentList = commandList.get(0).getContentList();
            int i = new Random().nextInt(contentList.size());
            return contentList.get(i).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }
}