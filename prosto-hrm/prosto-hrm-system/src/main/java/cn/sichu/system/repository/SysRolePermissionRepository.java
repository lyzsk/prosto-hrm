package cn.sichu.system.repository;

import cn.sichu.model.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sichu
 * @date 2023/01/16
 **/
public interface SysRolePermissionRepository extends JpaRepository<SysRolePermission, Long>, JpaSpecificationExecutor<SysRolePermission> {
}
