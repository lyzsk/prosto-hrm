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
    <img src="https://img.shields.io/badge/Language-HTML-3C415C?style=plastic&logo=html5&logoColor=E34F26" />
    <img src="https://img.shields.io/badge/Language-CSS-3C415C?style=plastic&logo=css3&logoColor=1572B6" />
    <img src="https://img.shields.io/badge/Language-JavaScript-3C415C?style=plastic&logo=javascript&logoColor=F7DF1E" />
    <img src="https://img.shields.io/badge/IDE-VSCode-3C415C?style=plastic&logo=visualstudiocode&logoColor=007ACC" />
    <img src="https://img.shields.io/badge/Framework-Vue.js-3C415C?style=plastic&logo=vue.js&logoColor=4FC08D" />
</p>

# Introduction

**hrms-vue** is the front-end project of **[human resource management system]** project by using **Vue.js** framework.

> :star:**_If you like this project or it helps you in some way, don't forget to star._**:star:

# Quick start

1. prepare **node.js** and **npm**, and install the modules for the project:

    ```
    npm install
    ```

    > NOTE: After installation, you should see `node_modules` directory in the root path.

2. start the front-end project in console:

    ```
    npm run serve
    ```

    open browser and visit: `http://localhost:8080`

    > NOTE: You should start **[back-end project]** first, to receive verifycode for login.
    >
    > How to start back-end project: @see **[README](../README.md)** or **[README.CN](../README.CN.md)**

3. (Optional for developer) build front-end project and apply new build into back-end project

    ```
    npm run build
    ```

    After build the project, copy all files in `dist` and paste into `hrms/hrms-server/hrms-web/src/main/resources/static` and replace the files.

[human resource management system]: https://github.com/lyzsk/human-resource-management-system
[back-end project]: ../hrms
