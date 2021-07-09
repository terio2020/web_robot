package com.terio.entity;

/**
 * Created by Terto_MY on 2021-07-07 10:30
 */
public class Message {
    /*
     *  主键
     * */
    private String id;
    /*
     * 指令名称
     * */
    private String command;
    /*
     * 指令描述
     * */
    private String description;
    /*
     * 回复内容
     * */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
