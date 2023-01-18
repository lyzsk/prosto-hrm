import request from "@/utils/request";

export function login(data) {
    return request({
        url: "/sys/login",
        method: "post",
        data,
    });
}

export function logout() {
    return request({
        url: "/sys/logout",
        method: "post",
    });
}
