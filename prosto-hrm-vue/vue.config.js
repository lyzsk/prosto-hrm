// const { defineConfig } = require("@vue/cli-service");

"use strict";

// path resolve svg
const path = require("path");
function resolve(dir) {
    return path.join(__dirname, dir);
}

// page title
const defaultSettings = require("./src/settings.js");
const name = defaultSettings.title || "ProstoHRM";

let proxyObj = {};
// proxyObj["/ws"] = {
//     ws: true,
//     target: "ws://localhost:8082",
// };
proxyObj["/"] = {
    ws: false,
    target: "http://localhost:8082",
    changeOrigin: true,
    pathRewrite: {
        "^/": "",
    },
};

module.exports = {
    devServer: {
        host: "localhost",
        port: 8080,
        proxy: proxyObj,
    },
    configureWebpack: {
        // provide the app's title in webpack's name field, so that
        // it can be accessed in index.html to inject the correct title.
        name: name,
        resolve: {
            alias: {
                "@": resolve("src"),
            },
        },
    },
    chainWebpack(config) {
        // set svg-sprite-loader
        config.module.rule("svg").exclude.add(resolve("src/icons")).end();
        config.module
            .rule("icons")
            .test(/\.svg$/)
            .include.add(resolve("src/icons"))
            .end()
            .use("svg-sprite-loader")
            .loader("svg-sprite-loader")
            .options({
                symbolId: "icon-[name]",
            })
            .end();
    },
};

// module.exports = defineConfig({
//     transpileDependencies: true,
//     chainWebpack(config) {
//         // set svg-sprite-loader
//         config.module.rule("svg").exclude.add(resolve("src/icons")).end();
//         config.module
//             .rule("icons")
//             .test(/\.svg$/)
//             .include.add(resolve("src/icons"))
//             .end()
//             .use("svg-sprite-loader")
//             .loader("svg-sprite-loader")
//             .options({
//                 symbolId: "icon-[name]",
//             })
//             .end();
//     },
// });
