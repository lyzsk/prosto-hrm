package cn.sichu.system.service;

import cn.sichu.system.dto.SysPermissionParam;

/**
 * @author sichu
 * @date 2023/01/12
 **/
public interface SysPermissionService {
    /**
     * 根据 param 添加 permission
     *
     * @param param SysPermissionParam
     */
    void addSysPermission(SysPermissionParam param);
}
