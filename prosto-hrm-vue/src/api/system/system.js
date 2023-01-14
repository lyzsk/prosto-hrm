import request from "@/utils/request";

export function getList(params) {
  return request({
    url: "/sys/users",
    method: "get",
    params,
  });
}
