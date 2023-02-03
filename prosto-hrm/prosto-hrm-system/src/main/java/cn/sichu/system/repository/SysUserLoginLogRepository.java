package cn.sichu.system.repository;

import cn.sichu.model.SysUserLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sichu
 * @date 2023/01/16
 **/
public interface SysUserLoginLogRepository
    extends JpaRepository<SysUserLoginLog, Long>, JpaSpecificationExecutor<SysUserLoginLog> {
}
