package cn.sichu.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/10
 **/
@Entity
@Table(name = "sys_role_permission")
@SQLDelete(sql = "update sys_role_permission set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
public class SysRolePermission {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人id
     */
    private Long createUser;

    /**
     * 更新人id
     */
    private Long updateUser;

    /**
     * 逻辑删除, 0: 否, 1: 是
     */
    private Integer isDeleted;

    public SysRolePermission() {
    }

    public SysRolePermission(Long id, Long roleId, Long permissionId, Date createTime, Date updateTime, Long createUser,
        Long updateUser, Integer isDeleted) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "SysRolePermission{" + "id=" + id + ", roleId=" + roleId + ", permissionId=" + permissionId
            + ", createTime=" + createTime + ", updateTime=" + updateTime + ", createUser=" + createUser
            + ", updateUser=" + updateUser + ", isDeleted=" + isDeleted + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
