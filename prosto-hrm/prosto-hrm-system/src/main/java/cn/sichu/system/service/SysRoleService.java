package cn.sichu.system.service;

import cn.sichu.system.dto.SysRoleParam;

/**
 * @author sichu
 * @date 2023/01/09
 **/
public interface SysRoleService {
    /**
     * 添加 role
     *
     * @param sysRoleParam sysRoleParam
     */
    void addSysRole(SysRoleParam sysRoleParam);

    /**
     * 根据 id 删除 role
     *
     * @param id id
     */
    void deleteSysRoleById(Long id);
}
