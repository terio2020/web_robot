# 开发步骤记录

**其实最主要的是将工程创建正确**

## 1、创建工程
 - 创建空白工程
 - File ——> New Project ——> Empty Project ——> 【确定名字】
 
## 2、创建module
 - 创建Java Web Application
 - File ——> New Module ——> Java ——> Java EE ——> Web Application ——> 【确定名字】
 
## 3、添加好Tomcat及其下面的`jsp-api.jar`和`servlet-api.jar`
 - File ——> Project Structure ——> Project Settings ——> Modules ——> 右侧`+` ——> 2.Library(Java)  ——> Tomcat
 - 若需添加那种自己下载的jar包
    - 将下载的jar包放在WEB-INF下的lib文件下
    - File ——> Project Structure ——> Project Settings ——> Modules ——> 右侧`+` ——> 1.JARs or Directories

## 4、正常编写工程代码
 - 注：连接mysql格式：
    - `jdbc:mysql//localhost:3306/database?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai"`
    
## 5、注意工程的编码问题
 - 前端页面显示的编码
 - 业务消息接收时的编码
 - 消息传递过程的编码
 - 使用UTF-8，不然容易中文乱码
 - 注：使用本地浏览器进行调试过程中，调试几次后注意要清除缓存，否则之前调试的错误样式可能无法更新
 
## 6、增加数据表，实现指令内容一对多
 - 原本的message表，仅用于网页的list显示，功能为回复【帮助】时有用
 - 新增的command表，对应了message中有的COMMAND（也可以另外新增），用于用户输入指令
 - 新增的command_content表，其中的COMMAND_ID对应了COMMAND的ID，用于随机返回一条指定COMMAND_ID的内容
 
## 7、