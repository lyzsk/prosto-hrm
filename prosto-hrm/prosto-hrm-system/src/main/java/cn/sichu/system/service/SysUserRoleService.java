package cn.sichu.system.service;

import cn.sichu.system.dto.SysUserRoleParam;

/**
 * @author sichu
 * @date 2023/01/09
 **/
public interface SysUserRoleService {
    /**
     * 根据 (userId, roleId) 添加 SysUserRoleRelation
     *
     * @param param SysUserRoleRelationParam
     */
    void addSysUserRole(SysUserRoleParam param);

    /**
     * 根据 user id 删除 SysUserRoleRelation
     *
     * @param userId user id
     */
    void deleteSysUserRoleByUserId(Long userId);

    /**
     * 根据 role id 删除 SysUserRoleRelation
     *
     * @param roleId role id
     */
    void deleteSysUserRoleByRoleId(Long roleId);
}
