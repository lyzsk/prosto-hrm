**[简体中文](./README.CN.md) | English**

<p align="center">
    <a href="https://github.com/lyzsk/hrms/blob/master/LICENSE">
        <img src="https://img.shields.io/github/license/lyzsk/hrms.svg?style=plastic&logo=github" />
    </a>
    <a href="https://github.com/lyzsk/hrms/members">
        <img src="https://img.shields.io/github/forks/lyzsk/hrms.svg?style=plastic&logo=github" />
    </a>
    <a href="https://github.com/lyzsk/hrms/stargazers">
        <img src="https://img.shields.io/github/stars/lyzsk/hrms.svg?style=plastic&logo=github" />
    </a>
</p>

<p align="center">
    <img src="https://img.shields.io/badge/language-Java-3C415C?style=plastic&logo=openjdk&logoColor=FFFFFF" />
    <img src="https://img.shields.io/badge/Language-HTML-3C415C?style=plastic&logo=html5&logoColor=E34F26" />
    <img src="https://img.shields.io/badge/Language-CSS-3C415C?style=plastic&logo=css3&logoColor=1572B6" />
    <img src="https://img.shields.io/badge/Language-JavaScript-3C415C?style=plastic&logo=javascript&logoColor=F7DF1E" />
</p>

<p align="center">
    <img src="https://img.shields.io/badge/IDE-IDEA-3C415C?style=plastic&logo=intellijidea&logoColor=FFFFFF" />
    <img src="https://img.shields.io/badge/IDE-VSCode-3C415C?style=plastic&logo=visualstudiocode&logoColor=007ACC" />
</p>

<p align="center">
    <img src="https://img.shields.io/badge/Framework-Spring-3C415C?style=plastic&logo=spring&logoColor=6DB33F" />
<img src="https://img.shields.io/badge/Framework-SpringBoot-3C415C?style=plastic&logo=springboot&logoColor=6DB33F" />
    <img src="https://img.shields.io/badge/Framework-SpringSecurity-3C415C?style=plastic&logo=springsecurity&logoColor=6DB33F" />
    <img src="https://img.shields.io/badge/Framework-Vue.js-3C415C?style=plastic&logo=vue.js&logoColor=4FC08D" />
</p>

# Introduction

This project uses **SpringBoot + Mybatis + Vue.js** to implement **full-stack** development for web-based human resource management system. Include using technologies: Redis, RabbitMQ, POI, FastDFS, WebSocket, Docker, Nginx, etc.

This project include two sub-projects:

-   Back-end project: [hrms]
-   Front-end project: [hrms-vue]

> :star: **_If you like this project or it helps you in some way, don't forget to star._** :star:

# Table of content

-   [Quick start](#quick-start)
    -   [back-end quick start](#back-end)
    -   [front-end quick start](#front-end)
-   [Key features and Preview](#key-features)

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

## **Back-end**

1. clone the project into your local disk:

    ```
    git clone git@github.com:lyzsk/human-resource-management-system.git
    ```

2. create database `hrms` and run SQL script `hrms/hrms-server/hrms-web/src/main/resources/db/hrms.sql` to import data into database.
3. setup `application.yml` in `hrms/hrms-server/hrms-web/src/main/resources`, including:

    - change `rabbitmq username, password, host, etc`
    - change `redis host, port, password, etc`

4. start **`mysql`, `redis`, `rabbitmq`** service:

    ```
    redis-server.exe redis.windows.conf

    rabbitmq-plugins enable rabbitmq_management
    ```

5. run `hrms/hrms-server/hrms-web/src/main/java/cn/sichu/hrms/HrmsApplication.java`

    open broser and visit: `http://localhost:8081/index.html`.

> **NOTE:** If you just want to see how the project works or you don't want to develop this project, you don't need to start **mail-server** back-end module and **hrms-vue** front-end project.
>
> 🌈 More details about the back-end project, @see **[README](./hrms/README.md)** or **[README.CN](./hrms/README.CN.md)**

## **Front-end**

1.  clone the project into your local disk:

    ```
    git clone git@github.com:lyzsk/human-resource-management-system.git
    ```

2.  prepare **node.js** and **npm**, and install the modules for the project:

    ```
    npm install
    ```

3.  start the front-end project in console:

    ```
    npm run serve
    ```

    open browser and visit: `http://localhost:8080`.

> 🌈 More details about the front-end project, @see **[README](./hrms-vue/README.md)** or **[README.CN](./hrms-vue/README.CN.md)**

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

> NOTE: More Details about implementation of the features
>
> @see [backend-README](./hrms/README.md) and [frontend-README](./hrms-vue/README.md), or [backend-README.CN](./hrms/README.CN.md) and [frontend-README.CN](./hrms-vue/README.CN.md)

## Basic CRUD

basic Create, Read, Update, Delete features for mangaging the data, including:

1. CRUD employees information.

    CRUD employees information including: employee id, gender, date of birth, nationality, phone number, email, address, department, job level, etc...

2. CRUD salary template.

    Provide salary template to faster employee salary management, and will show current step and remaining steps when editing the salary template.

    HR could adjust employee salary with salary template, which will fasten the workflows.

3. CRUD different roles (different authorities).

    Users with different roles will receive different menu with different features after login.

    Different role could access and do different things, for example:

    The **train + recruiter ROLE** could only access **employee traning** menu, however, The **personnel manager + train + performance + recruiter ROLE** could access **employee information + training + salary + rewards + department management** menus.

    Also, allow admin level roles to adjust/manageme lower level roles account authorities.

> More CRUD features... You can just run the project and understand by yourself.

### Preview

-   add new employee:

    ![preview][preview-01]

## Login module

1. Login with password and verifycode. Implement random verifycode generator.
2. Auto kick-offline when user login in another terminal.
3. Add salt to user password before storing in database to protect user information.
4. Save login status after login, avoid losing data after refresh (F5).

The key technology of this module is using `SpringSecurity`, `Filter`, `Vuex.Store` and `awt.Graphics` to implement.

### Preview

-   login with password and random verifycode:

    ![preview][preview-02]

## Excel management

1. Allows HR to import employee excel table from local disk and update MySQL database.
2. Allows HR to export employee excel table from MySQL database into local disk.
3. Allow key words search and fuzzy search for employees in web content.

The key technology of this module is using `apache.POI` and `axios` to implement.

### Preview

-   export excel:

    ![preview][preview-03]

## Online chat

1. one-to-one chat with another HR.
2. group chat with HRs.
3. notification when receive message.
4. Save chat data with `Vuex.Store.localStorage`, avoid losing data after refresh (F5).

The key technology of this module is using `WebSocket` to implement.

### Preview

-   one-to-one chat

    ![preview][preview-04]

## Account setting

1. Allow user to set username, phone number, tele number, address.
2. Allow user to set new password.
3. Allow user to set new icon.
4. All the settings include files will using FastDFS to upload into nginx server (default `http://192.168.91.128/`).

The key technology of this module is using `FastDFS` to implement.

### Preview

-   ![preview][preview-05]

## Menu Caching and Dynamic loading components

1. Enable redis caching for menu beacause this is the main entrence of every features and will being load many times.
2. Apply Dynamic Loading to components to improve the performance.

The key technology of this module is using `Redis` and `Global Before Guards` to implement.

### Preview

-   Dynamic loading components:

    ![preview][preview-06]

## Email module with Redis and RabbitMQ

1. Auto send email to new employee after being added.

The key technology of this module is using `thymeleaf`, `Redis` and `RabbitMQ` to implement.

### Preview

-   auto email with template:

    ![preview][preview-07]

##

> More features you can run the project and discover by yourself.💖
>
> Or see the hrms project previews in my support-repo: C:\Users\sichu\dev\support-repo\human-resource-management-system\previews

# TODO

-   update README.CN
-   Fix email bugs
-   replace Mybatis with Hibernate.

[hrms]: ./hrms
[hrms-vue]: ./hrms-vue
[basic crud]: #basic-crud
[login module]: #login-module
[excel management]: #excel-management
[online chat]: #online-chat
[account setting]: #account-setting
[menu caching and dynamic loading components]: #menu-caching-and-dynamic-loading-components
[email module with redis and rabbitmq]: #email-module-with-redis-and-rabbitmq
[preview-01]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/add-new-employee.gif?raw=true
[preview-02]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/login-with-password-and-verifycode.gif?raw=true
[preview-03]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/export-excel-and-key-words-search.gif?raw=true
[preview-04]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/one-to-one-chat.gif?raw=true
[preview-05]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/account-setting.gif?raw=true
[preview-06]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/dynamic-loading-components.gif?raw=true
[preview-07]: https://github.com/lyzsk/support-repo/blob/master/human-resource-management-system/previews/auto-email-with-template.png?raw=true
