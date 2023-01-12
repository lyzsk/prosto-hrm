package cn.sichu.system.dto;

/**
 * @author sichu
 * @date 2023/01/12
 **/
public class SysRolePermissionParam {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 权限id
     */
    private Long permissionId;

    public SysRolePermissionParam() {
    }

    public SysRolePermissionParam(Long userId, Long permissionId) {
        this.userId = userId;
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "SysRolePermissionParam{" + "userId=" + userId + ", permissionId=" + permissionId + '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
