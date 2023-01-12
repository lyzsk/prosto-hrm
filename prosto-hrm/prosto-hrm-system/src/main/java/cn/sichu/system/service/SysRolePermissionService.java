package cn.sichu.system.service;

import cn.sichu.system.dto.SysRolePermissionParam;

/**
 * @author sichu
 * @date 2023/01/12
 **/
public interface SysRolePermissionService {
    /**
     * 添加 sysRolePermission 关系
     *
     * @param param param
     */
    void addSysRolePermission(SysRolePermissionParam param);
}
