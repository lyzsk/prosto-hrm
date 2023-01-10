package cn.sichu.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/07
 **/
@Entity
@Table(name = "sys_role")
@SQLDelete(sql = "UPDATE sys_role SET is_deleted = 1 WHERE id = ?")
@Where(clause = "is_deleted = 0")
public class SysRole implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 状态, 0: 禁用, 1: 启用
     * 默认值: 1
     */
    private Integer status;

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
     * 默认值: 0
     */
    private Integer isDeleted;

    public SysRole() {
    }

    public SysRole(Long id, Long parentId, String code, String name, String description, Integer status,
        Date createTime, Date updateTime, Long createUser, Long updateUser, Integer isDeleted) {
        this.id = id;
        this.parentId = parentId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "SysRole{" + "id=" + id + ", parentId=" + parentId + ", code='" + code + '\'' + ", name='" + name + '\''
            + ", description='" + description + '\'' + ", status=" + status + ", createTime=" + createTime
            + ", updateTime=" + updateTime + ", createUser=" + createUser + ", updateUser=" + updateUser
            + ", isDeleted=" + isDeleted + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
