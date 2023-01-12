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
@Table(name = "sys_user")
@SQLDelete(sql = "update sys_user set is_deleted=1 where id=?")
@Where(clause = "is_deleted=0")
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 电话区号
     */
    private String countryCode;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户状态, 0: 禁用, 1: 启用
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
     * 最近登录时间
     */
    private Date lastLoginTime;
    /**
     * 逻辑删除, 0: 否, 1: 是
     * 默认值: 0
     */
    private Integer isDeleted;

    public SysUser() {
    }

    public SysUser(Long id, String username, String password, String name, String email, String countryCode,
        String phone, String avatar, Integer status, Date createTime, Date updateTime, Long createUser, Long updateUser,
        Date lastLoginTime, Integer isDeleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.countryCode = countryCode;
        this.phone = phone;
        this.avatar = avatar;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.lastLoginTime = lastLoginTime;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "SysUser{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\''
            + ", name='" + name + '\'' + ", email='" + email + '\'' + ", countryCode='" + countryCode + '\''
            + ", phone='" + phone + '\'' + ", avatar='" + avatar + '\'' + ", status=" + status + ", createTime="
            + createTime + ", updateTime=" + updateTime + ", createUser=" + createUser + ", updateUser=" + updateUser
            + ", lastLoginTime=" + lastLoginTime + ", isDeleted=" + isDeleted + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}
