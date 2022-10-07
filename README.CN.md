**简体中文 | [English](./README.md)**

<p align="center">
    <a href="https://github.com/lyzsk/analysis-of-herbarium-sheets/blob/master/LICENSE">
        <img src="https://img.shields.io/github/license/lyzsk/analysis-of-herbarium-sheets.svg?style=plastic&logo=github" />
    </a>
    <a href="https://github.com/lyzsk/analysis-of-herbarium-sheets/members">
        <img src="https://img.shields.io/github/forks/lyzsk/analysis-of-herbarium-sheets.svg?style=plastic&logo=github" />
    </a>
    <a href="https://github.com/lyzsk/analysis-of-herbarium-sheets/stargazers">
        <img src="https://img.shields.io/github/stars/lyzsk/analysis-of-herbarium-sheets.svg?style=plastic&logo=github" />
    </a>
</p>

<p align="center">
    <img src="https://img.shields.io/badge/language-Java-3C415C?style=plastic&logo=openjdk&logoColor=FFFFFF" />
    <img src="https://img.shields.io/badge/IDE-IDEA-3C415C?style=plastic&logo=intellijidea&logoColor=FFFFFF" />
    <img src="https://img.shields.io/badge/IDE-Eclipse-3C415C?style=plastic&logo=eclipse&logoColor=FFFFFF" />
    <img src="https://img.shields.io/badge/Framework-Spring-3C415C?style=plastic&logo=spring&logoColor=6DB33F" />
<img src="https://img.shields.io/badge/Framework-SpringBoot-3C415C?style=plastic&logo=springboot&logoColor=6DB33F" />
    <img src="https://img.shields.io/badge/Framework-SpringSecurity-3C415C?style=plastic&logo=springsecurity&logoColor=6DB33F" />
</p>

# Introduction

这个项目使用 **SpringBoot + Mybatis + Vue.js** 实现 **全栈** 开发 web 人力资源管理系统. 包含技术栈: Redis, RabbitMQ, POI, FastDFS, WebSocket, Docker, Nginx, etc.

这个项目包含两个子项目:

-   后端项目: [hrms]
-   前端项目: [hrms-vue]

> :star: **_如果你喜欢这个项目, 或者这个项目对你有帮助, 别忘了点赞哦_** :star:

# Table of content

-   [快速上手](#quick-start)
    -   [back-end quick start](#back-end)
    -   [front-end quick start](#front-end)
-   [主要功能和预览](#key-features)

    -   [Basic CRUD]
        -   [preview](#preview)
    -   [Login module]
        -   [preview](#preview-1)
    -   [Excel management]
        -   [preview](#preview-2)
    -   [Online chat]
        -   [preview](#preview-3)
    -   [Account setting]
        -   [preview](#preview-4)
    -   [Menu caching and Dynamic loading components]
        -   [preview](#preview-5)
    -   [Email module with Redis and RabbitMQ]
        -   [preview](#preview-6)
    -   etc.....

# Quick start

## **后端**

1. clone 项目到本地:

    ```
    git clone git@github.com:lyzsk/human-resource-management-system.git
    ```

2. 创建一个数据库 `hrms`, 运行 SQL 脚本 `hrms/hrms-server/hrms-web/src/main/resources/db/hrms.sql` 导入数据.
3. 设置 `application.yml` 在 `hrms/hrms-server/hrms-web/src/main/resources` 目录下, 包括:

    - 更改 `rabbitmq username, password, host, etc`
    - 更改 `redis host, port, password, etc`

4. 启动 **`mysql`, `redis`, `rabbitmq`** service:

    ```
    redis-server.exe redis.windows.conf

    rabbitmq-plugins enable rabbitmq_management
    ```

5. 运行 `hrms/hrms-server/hrms-web/src/main/java/cn/sichu/hrms/HrmsApplication.java`

    打开浏览器并访问: `http://localhost:8081/index.html`.

> **NOTE:** 如果你是想看项目效果, 并不想二次开发的话, 你不需要启动 **mail-server** 模块和 **hrms-vue** 前端项目.
>
> 🌈 关于后端项目的更多细节, @see **[README](./hrms/README.md)** or **[README.CN](./hrms/README.CN.md)**

## **前端**

1.  clone 项目到本地:

    ```
    git clone git@github.com:lyzsk/human-resource-management-system.git
    ```

2.  准备 **node.js** and **npm**, 并且安装项目需要的模块:

    ```
    npm install
    ```

3.  启动前端模块:

    ```
    npm run serve
    ```

    open browser and visit: `http://localhost:8080`.

> 🌈 关于前端项目的更多细节, @see **[README](./hrms-vue/README.md)** or **[README.CN](./hrms-vue/README.CN.md)**

# Key features

|  #  |                 feature name                  |        preview        |               |
| :-: | :-------------------------------------------: | :-------------------: | :-----------: |
|  1  |                 [Basic CRUD]                  |  [preview](#preview)  | [back to top] |
|  2  |                [Login module]                 | [preview](#preview-1) | [back to top] |
|  3  |              [Excel management]               | [preview](#preview-2) | [back to top] |
|  4  |                 [Online chat]                 | [preview](#preview-3) | [back to top] |
|  5  |               [Account setting]               | [preview](#preview-4) | [back to top] |
|  6  | [Menu Caching and Dynamic loading components] | [preview](#preview-5) | [back to top] |
|  7  |    [Email module with Redis and RabbitMQ]     | [preview](#preview-6) | [back to top] |

> 注意: 更多有关功能的实现细节
>
> @see [backend-README](./hrms/README.md) and [frontend-README](./hrms-vue/README.md), or [backend-README.CN](./hrms/README.CN.md) and [frontend-README.CN](./hrms-vue/README.CN.md)

## Basic CRUD

实现基本的 CRUD 增删查改功能, 其中包含:

1. CRUD 员工信息.

    CRUD 员工信息包含: 工号 id, 性别, 出生日期, 国籍, 电话号码, 邮箱地址, 住址, 所属部门, 工作职位, etc...

2. CRUD 工资套账.

    提供工资套账加快工资管理流程, 编辑工资套账时会提供相应的 step 信息.

    HR 可以通过工资套账设置员工工资, 加快工作流程

3. CRUD 不同 roles (不同权限).

    用户登陆后会根据所属的不同 ROLE 得到不同的 menu 菜单.

    不同的 ROLE 可以访问的菜单不同, 比如:

    The **train + recruiter ROLE** could only access **employee traning** menu, however, The **personnel manager + train + performance + recruiter ROLE** could access **employee information + training + salary + rewards + department management** menus.

    并且允许 admin 用户管理其他用户的权限设置

> More CRUD features... 你可以自己跑一下项目体会一下.

### Preview

-   添加员工, 并且对填入的信息进行信息格式校对:

    ![preview][preview-01]

## Login module

1. 设置通过 密码 + 验证码 登录, 实现随机验证码生成器
2. 多端登录自动踢下线.
3. 密码加密后再加盐处理, 然后再存入数据库, 保障用户信息安全.
4. 登陆后保存用户登录状态, 防止 F5 刷新后数据丢失.

The key technology of this module is using `SpringSecurity`, `Filter`, `Vuex.Store` and `awt.Graphics` to implement.

### Preview

-   密码 + 验证码登录:

    ![preview][preview-02]

## Excel management

1. 允许 HR 导出员工表 excel 文件到本地
2. 允许 HR 从本地导入员工表 excel 文件
3. 关键词搜索和模糊搜索
4. 高级搜索功能

这些功能主要使用 `apache.POI` and `axios` 来实现.

### Preview

-   export excel, key words search, search with filters:

    ![preview][preview-03]

## Online chat

1. 一对一聊天.
2. 群组聊天.
3. 系统通知.
4. 聊天数据保存到 `Vuex.Store.localStorage`, 防止 F5 刷新后数据丢失.

这些功能主要使用 `WebSocket` 来实现.

### Preview

-   一对一聊天:

    ![preview][preview-04]

## Account setting

1. 允许用户修改信息: 用户名, 电话号码, 手机号码, 住址
2. 允许用户修改密码
3. 允许用户设置头像
4. 用户上传的文件通过 FastDFS 上传到 nginx server (default `http://192.168.91.128/`).

这些功能主要使用 `FastDFS` 来实现.

### Preview

-   用户修改信息, 更改密码:

    ![preview][preview-05]

## Menu Caching and Dynamic loading components

1. menu 菜单栏通过 redis 缓存, 因为这一部分是所有功能的主入口, 用户最经常访问.
2. 组件动态加载提高性能.

这些功能主要使用 `Redis` and `Global Before Guards` 来实现.

### Preview

-   动态加载组件:

    ![preview][preview-06]

## Email module with Redis and RabbitMQ

1. 新增员工(用户), 自动发送模板邮件

这些功能主要使用 `thymeleaf`, `Redis` and `RabbitMQ` 来实现.

### Preview

-   自动发送邮件模板:

    ![preview][preview-07]

##

> 更多功能可以跑一下项目自行体会.💖
>
> 或者查看我的 support-repo 仓库观看 Previews: https://github.com/lyzsk/support-repo/tree/master/human-resource-management-system/previews

# TODO

-   update README.CN
-   Fix email bugs
-   replace Mybatis with Hibernate.

[back to top]: #introduction
[hrms]: ./hrms
[hrms-vue]: ./hrms-vue
[basic crud]: #basic-crud
[login module with springsecurity]: #login-module-with-springsecurity
[excel management with poi and axios]: #excel-management-with-poi-and-axios
[online chat with websocket]: #online-chat-with-websocket
[account setting with fastdfs file upload]: #account-setting-with-fastdfs-file-upload
[menu caching with redis and vue dynamic loading components]: #menu-caching-with-redis-and-vue-dynamic-loading-components
[email module with redis and rabbitmq]: #email-module-with-redis-and-rabbitmq
[preview-01]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/add-new-employee.gif?raw=true
[preview-02]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/login-with-password-and-verifycode.gif?raw=true
[preview-03]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/export-excel-and-key-words-search.gif?raw=true
[preview-04]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/one-to-one-chat.gif?raw=true
[preview-05]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/account-setting.gif?raw=true
[preview-06]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/dynamic-loading-components.gif?raw=true
[preview-07]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/auto-email-with-template.png?raw=true
