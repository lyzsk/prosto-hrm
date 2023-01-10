package cn.sichu.system.dao;

import cn.sichu.model.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sichu
 * @date 2023/01/10
 **/
public interface SysPermissionDao extends JpaRepository<SysPermission, Long>, JpaSpecificationExecutor<SysPermission> {
}
