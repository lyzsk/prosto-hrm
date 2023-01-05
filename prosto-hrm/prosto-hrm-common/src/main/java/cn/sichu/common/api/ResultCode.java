package cn.sichu.common.api;

/**
 * 通用返回状态码
 *
 * @author sichu
 * @date 2023/01/03
 **/
public enum ResultCode implements IResultCode {
    /**
     * 成功: 200
     */
    SUCCESS(200, "操作成功!"),
    /**
     * 失败: 500
     */
    FAIL(500, "操作失败!"),
    /**
     * 未登录: 401
     */
    UNAUTHENTICATED(401, "未登录, 请先登录!"),
    /**
     * 未授权: 403
     */
    UNAUTHORIZED(403, "没有相关权限!"),
    /**
     * 页面未找到: 404
     */
    NOTFOUND(404, "抱歉, 页面不存在!"),
    /**
     * 服务器错误: 500
     */
    Internal_Server_Error(404, "抱歉, 系统繁忙, 请稍后尝试!"),
    /**
     * 未知错误: 999
     */
    ERROR(999, "未知错误!");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
