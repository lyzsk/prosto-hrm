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

**hrms** is the back-end project of **[human resource management system]** project by using **SpringBoot** framework and **MyBatis** persistence framework.

> :star: **_If you like this project or it helps you in some way, don't forget to star._** :star:

# Quick start

1. clone the project into your local disk:

    ```
    git clone git@github.com:lyzsk/human-resource-management-system.git
    ```

2. create database `hrms` and run SQL script `hrms/hrms-server/hrms-web/src/main/resources/db/hrms.sql` to get the data for this project.
3. setup `application.yml` in `hrms/hrms-server/hrms-web/src/main/resources`, including:

    - change `rabbitmq username, password, host, etc`
    - change `redis host, port, password, etc`

4. start **`mysql`, `redis`, `rabbitmq`** service:

    ```
    redis-server.exe redis.windows.conf

    rabbitmq-plugins enable rabbitmq_management
    ```

5. run `hrms/hrms-server/hrms-web/src/main/java/cn/sichu/hrms/HrmsApplication.java`

# TODO

-   implementation details

[human resource management system]: https://github.com/lyzsk/human-resource-management-system
