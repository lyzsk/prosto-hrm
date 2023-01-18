import axios from "axios";
import { MessageBox, Message } from "element-ui";
import store from "@/store";
import { getToken } from "@/utils/auth";

const service = axios.create({
    // url = baseURL + request url
    baseURL: "",
    timeout: 5000,
});

service.interceptors.request.use(
    (config) => {
        /**
         * before request is sent, check token
         * if token in cookie, get token, set config.header with token
         * else return config
         */
        if (store.getters.token) {
            config.headers["Authorization"] = getToken();
        }
        console.log(config);
        return config;
    },
    (error) => {
        console.log(error);
        return Promise.reject(error);
    }
);

service.interceptors.response.use(
    (response) => {
        const res = response.data;
        // if Result.code !== 200 success
        if (res.code !== 200) {
            Message({
                message: res.message || "Error",
                type: "error",
                duration: 5 * 1000,
            });
            return Promise.reject(new Error(res.message || "Error"));
        } else {
            return res;
        }
    },
    (error) => {
        console.log("error" + error);
        Message({
            message: error.message,
            type: "error",
            duration: 5 * 1000,
        });
        return Promise.reject(error);
    }
);

export default service;
