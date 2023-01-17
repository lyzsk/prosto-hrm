package cn.sichu.system.repository;

import cn.sichu.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author sichu
 * @date 2023/01/16
 **/
public interface SysUserRepository extends JpaRepository<SysUser, Long>, JpaSpecificationExecutor<SysUser> {
    /**
     *
     * @param username username
     * @return SysUser 对象
     */
    @Query(value = "select su from SysUser su where su.username=:username")
    SysUser findByUsername(@Param("username") String username);
}
