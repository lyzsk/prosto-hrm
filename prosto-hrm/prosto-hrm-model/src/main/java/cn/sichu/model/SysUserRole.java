package cn.sichu.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * HRM系统用户和角色关系表
 *
 * @author sichu
 * @date 2023/01/09
 **/
@Entity
@Table(name = "sys_user_role")
@SQLDelete(sql = "update sys_user_role set is_delete = 1 where id = ?")
@Where(clause = "is_deleted = 0")
public class SysUserRole implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

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

    public SysUserRole() {
    }

    public SysUserRole(Long id, Long userId, Long roleId, Date createTime, Date updateTime, Long createUser,
        Long updateUser, Integer isDeleted) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "SysUserRole{" + "id=" + id + ", userId=" + userId + ", roleId=" + roleId + ", createTime=" + createTime
            + ", updateTime=" + updateTime + ", createUser=" + createUser + ", updateUser=" + updateUser
            + ", isDeleted=" + isDeleted + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
