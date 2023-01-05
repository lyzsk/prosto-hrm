package cn.sichu.common.exception;

import cn.sichu.common.api.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 *
 * @author sichu
 * @date 2023/01/04
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param e exception
     * @return 自定义message的Result.error, 或 Result.error
     */
    @ExceptionHandler(value = GlobalException.class)
    public Result<Object> handle(GlobalException e) {
        if (e.getResultCode() != null) {
            return Result.error(e.getResultCode());
        }
        return Result.error(e.getMessage());
    }
}
