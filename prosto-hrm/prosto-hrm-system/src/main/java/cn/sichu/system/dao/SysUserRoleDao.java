package cn.sichu.system.dao;

import cn.sichu.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sichu
 * @date 2023/01/09
 **/
public interface SysUserRoleDao extends JpaRepository<SysUserRole, Long>, JpaSpecificationExecutor<SysUserRole> {

    /**
     * 根据 user id 删除 SysUserRole
     *
     * @param userId user id
     */
    @Transactional
    @Modifying
    @Query(
        value = "update sys_user_role sur left join sys_user su on sur.user_id = su.id and su.id = ? set sur.is_deleted = 1 where sur.is_deleted = 0",
        nativeQuery = true)
    void deleteByUserId(Long userId);

    /**
     * 根据 SysUser 对象的 id, 通过 SysUserRoleDao 获取 SysRole 对象作为 authorities
     *
     * @param userId user id
     * @return SysRole list
     */
    @Query(
        value = "select sr.code from sys_user_role sur left join sys_user su on sur.user_id = su.id and su.id = ? left join sys_role sr on sur.role_id = sr.id ",
        nativeQuery = true)
    List<String> getRoleList(Long userId);
}
