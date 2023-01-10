package cn.sichu.system.dao;

import cn.sichu.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
        value = "update sys_user_role sur left join sys_user su on sur.user_id = su.id set sur.is_deleted = 1 where sur.is_deleted = 0",
        nativeQuery = true)
    void deleteByUserId(Long userId);
}
