package cn.sichu.system.dao;

import cn.sichu.model.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author sichu
 * @date 2023/01/07
 **/
public interface SysUserDao extends JpaRepository<SysUser, Long>, JpaSpecificationExecutor<SysUser> {
    /**
     * 根据 username 查询 SysUser
     *
     * @param username username
     * @return SysUser
     */
    @Query(value = "select su from SysUser su where username=:username")
    SysUser findByUsername(@Param("username") String username);

    @Query(value = "select su.id, su.name, su.username, su.email, su.countryCode, su.phone, su.status, "
        + "su.createTime, su.updateTime, su.createUser, su.updateUser from SysUser su")
    Page<SysUser> findAllExcludePassword(Pageable pageable);
}
