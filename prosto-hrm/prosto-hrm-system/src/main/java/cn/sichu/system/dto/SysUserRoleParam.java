package cn.sichu.system.dto;

/**
 * SysUserRole 的 dto, 用于 add
 *
 * @author sichu
 * @date 2023/01/09
 **/
public class SysUserRoleParam {
    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 角色 id
     */
    private Long roleId;

    public SysUserRoleParam() {
    }

    public SysUserRoleParam(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserRoleParam{" + "userId=" + userId + ", roleId=" + roleId + '}';
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
}
