package cn.sichu.common.api;

/**
 * 封装返回状态码码API
 *
 * @author sichu
 * @date 2023/01/03
 **/
public interface IResultCode {
    int getCode();

    String getMessage();
}
