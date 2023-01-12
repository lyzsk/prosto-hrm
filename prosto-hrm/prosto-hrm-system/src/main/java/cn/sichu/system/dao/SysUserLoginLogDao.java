package cn.sichu.system.dao;

import cn.sichu.model.SysUserLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sichu
 * @date 2023/01/11
 **/
public interface SysUserLoginLogDao
    extends JpaRepository<SysUserLoginLog, Long>, JpaSpecificationExecutor<SysUserLoginLog> {
}
