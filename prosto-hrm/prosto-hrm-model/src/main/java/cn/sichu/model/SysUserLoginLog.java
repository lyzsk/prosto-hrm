package cn.sichu.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/11
 **/
@Entity
@Table(name = "sys_user_login_log")
@SQLDelete(sql = "update sys_user_login_log set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
public class SysUserLoginLog {
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
     * 登录时间
     */
    private Date loginTime;

    /**
     * 登录ip
     */
    private String ip;
    /**
     * 逻辑删除, 0: 否, 1: 是
     */
    private Integer isDeleted;

    public SysUserLoginLog() {
    }

    public SysUserLoginLog(Long id, Long userId, Date loginTime, String ip, Integer isDeleted) {
        this.id = id;
        this.userId = userId;
        this.loginTime = loginTime;
        this.ip = ip;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "SysUserLoginLog{" + "id=" + id + ", userId=" + userId + ", loginTime=" + loginTime + ", ip='" + ip
            + '\'' + ", isDeleted=" + isDeleted + '}';
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
