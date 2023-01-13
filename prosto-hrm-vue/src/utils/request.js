import axios from "axios";
import { MessageBox, Message } from "element-ui";
import store from "@/store";
import { getToken } from "@/utils/auth";

// create an axios instance
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  timeout: 5000, // request timeout
});

// request interceptor
service.interceptors.request.use(
  (config) => {
    // do something before request is sent

    if (store.getters.token) {
      // let each request carry token
      // ['X-Token'] is a custom headers key
      // please modify it according to the actual situation
      config.headers["Authorization"] = getToken();
    }
    return config;
  },
  (error) => {
    // do something with request error
    Message.error("请求出错了");
    console.log(error); // for debug
    return Promise.reject(error);
  }
);

// response interceptor
service.interceptors.response.use(
  (response) => {
    const res = response.data;
    const code = res.code;
    if (code != 200) {
      Message({
        message: res.message,
        type: "error",
        duration: 5 * 1000,
      });
    }
    return res;
  },
  (error) => {
    console.log("err" + error); // for debug
    Message({
      message: error.message,
      type: "error",
      duration: 5 * 1000,
    });
    return Promise.reject(error);
  }
);

export default service;

// export const createAPI = (url, method, data) => {
//   let config = {};
//   if (method === "get") {
//     config.params = data;
//   } else {
//     config.data = data;
//   }
//   return service({
//     url,
//     method,
//     ...config,
//   });
// };

// export const createFormAPI = (url, method, data) => {
//   let config = {}
//   config.data = data
//   config.headers = {
//     'Cache-Control': 'no-cache',
//     'Content-Type': 'application/x-www-form-urlencoded'
//   }
//   config.responseType = 'json'
//   config.transformRequest = [
//     function(data) {
//       let ret = ''
//       for (let it in data) {
//         ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
//       }
//       return ret
//     }
//   ]
//   return service({
//     url,
//     method,
//     ...config
//   })
// }
