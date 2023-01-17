package cn.sichu.system.service;

import cn.sichu.model.SysUser;
import cn.sichu.system.dto.SysUserParam;

/**
 * @author sichu
 * @date 2023/01/16
 **/
public interface SysUserService {
    /**
     * 根据 SysUserParam 注册
     *
     * @param param SysUserParam
     * @return 1: 成功, 0: 失败
     */
    int register(SysUserParam param);

    /**
     * 根据 username 获取 SysUser 对象
     *
     * @param username username
     * @return SysUser 对象
     */
    SysUser getSysUserByUsername(String username);

    /**
     * 根据 id 删除用户
     *
     * @param id SysUser id
     * @return 1: 成功, 0: 失败
     */
    int deleteSysUserById(Long id);
}
