package cn.sichu.system.service.impl;

import cn.sichu.model.SysUserLoginLog;
import cn.sichu.system.dao.SysUserLoginLogDao;
import cn.sichu.system.service.SysUserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sichu
 * @date 2023/01/11
 **/
public class SysUserLoginLogServiceImpl implements SysUserLoginLogService {
    @Autowired
    SysUserLoginLogDao sysUserLoginLogDao;

    @Override
    public void addLoginLog(SysUserLoginLog loginLog) {
        sysUserLoginLogDao.save(loginLog);
    }
}
