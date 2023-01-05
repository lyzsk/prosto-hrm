package cn.sichu.common.exception;

import cn.sichu.common.api.IResultCode;

/**
 * 全局异常捕获, 捕获API异常
 *
 * @author sichu
 * @date 2023/01/04
 **/
public class GlobalException extends RuntimeException {
    private IResultCode resultCode;

    public GlobalException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public GlobalException(String message) {
        super(message);
    }

    public IResultCode getResultCode() {
        return resultCode;
    }
}
