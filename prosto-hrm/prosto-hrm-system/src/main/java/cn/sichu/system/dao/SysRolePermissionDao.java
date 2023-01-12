package cn.sichu.system.dao;

import cn.sichu.model.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sichu
 * @date 2023/01/12
 **/
public interface SysRolePermissionDao
    extends JpaRepository<SysRolePermission, Long>, JpaSpecificationExecutor<SysRolePermission> {
}
