package cn.sichu.system.service;

import cn.sichu.model.SysUser;
import cn.sichu.system.dto.SysUserParam;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * SysUserService 接口
 *
 * @author sichu
 * @date 2023/01/07
 **/
public interface SysUserService {
    /**
     * 用户注册
     *
     * @param param sysUserParam
     * @return SysUser
     */
    SysUser register(SysUserParam param);

    /**
     * 根据 username 获取 SysUser
     *
     * @param username username
     * @return SysUser
     */
    SysUser getSysUserByUsername(String username);

    /**
     * 根据 username 获取 UserDetails 对象
     *
     * @param username username
     * @return UserDetails
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 用户登录
     *
     * @param username username
     * @param password password
     * @return token
     */
    String login(String username, String password);

    /**
     * 添加登录记录
     *
     * @param username username
     */
    void addLoginLog(String username);

    /**
     * 根据用户id获取用户
     *
     * @param id id
     * @return SysUser
     */
    SysUser getSysUserById(Long id);

    /**
     * 根据 id 删除用户
     *
     * @param id id
     */
    void deleteSysUserById(Long id);
}
