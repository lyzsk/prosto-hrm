package cn.sichu.system.dao;

import cn.sichu.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sichu
 * @date 2023/01/09
 **/
public interface SysRoleDao extends JpaRepository<SysRole, Long>, JpaSpecificationExecutor<SysRole> {
}
