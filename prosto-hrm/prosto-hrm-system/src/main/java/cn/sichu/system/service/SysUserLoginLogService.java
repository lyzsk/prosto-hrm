package cn.sichu.system.service;

import cn.sichu.model.SysUserLoginLog;

/**
 * @author sichu
 * @date 2023/01/11
 **/
public interface SysUserLoginLogService {
    /**
     * 添加登录记录
     *
     * @param loginLog SysUserLoginLog
     */
    void addLoginLog(SysUserLoginLog loginLog);
}
