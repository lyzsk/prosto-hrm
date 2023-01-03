package cn.sichu.common.api;

import java.io.Serializable;

/**
 * 通用返回结果封装类
 *
 * @author sichu
 * @date 2023/01/03
 **/
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 操作成功返回结果
     *
     * @param data 获取的数据
     * @param <T>  对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 操作成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     * @param <T>     对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败返回结果
     *
     * @param <T> 对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> failed() {
        return new Result<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), null);
    }

    /**
     * 操作失败返回结果
     *
     * @param message 提示信息
     * @param <T>     对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> failed(String message) {
        return new Result<>(ResultCode.FAIL.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     *
     * @param <T> 对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> unauthenticated() {
        return new Result<>(ResultCode.UNAUTHENTICATED.getCode(), ResultCode.UNAUTHENTICATED.getMessage(), null);
    }

    /**
     * 未登录返回结果
     *
     * @param message 提示信息
     * @param <T>     对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> unauthenticated(String message) {
        return new Result<>(ResultCode.UNAUTHENTICATED.getCode(), message, null);
    }

    /**
     * 未授权返回结果
     *
     * @param <T> 对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> unauthorized() {
        return new Result<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    /**
     * 未授权返回结果
     *
     * @param message 提示信息
     * @param <T>     对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> unauthorized(String message) {
        return new Result<>(ResultCode.UNAUTHORIZED.getCode(), message, null);
    }

    /**
     * 未找到资源返回结果
     *
     * @param <T> 对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> notfound() {
        return new Result<>(ResultCode.NOTFOUND.getCode(), ResultCode.NOTFOUND.getMessage(), null);
    }

    /**
     * 服务器错误返回结果
     *
     * @param <T> 对象类型
     * @return Result<T></>
     */
    public static <T> Result<T> internalServerError() {
        return new Result<>(ResultCode.Internal_Server_Error.getCode(), ResultCode.Internal_Server_Error.getMessage(),
            null);
    }

    @Override
    public String toString() {
        return "Result{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
