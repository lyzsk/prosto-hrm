package cn.sichu.system.bo;

import cn.sichu.common.constant.Status;
import cn.sichu.model.SysPermission;
import cn.sichu.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity 需要的用户信息封装类
 *
 * @author sichu
 * @date 2023/01/10
 **/
public class SysUserDetails implements UserDetails {
    private final SysUser sysUser;
    private final List<SysPermission> permissionList;

    public SysUserDetails(SysUser sysUser, List<SysPermission> permissionList) {
        this.sysUser = sysUser;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionList.stream().filter(permission -> permission.getId() != null)
            .filter(permission -> permission.getCode() != null)
            .map(permission -> new SimpleGrantedAuthority(permission.getId() + ":" + permission.getCode()))
            .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.sysUser.getStatus().equals(Status.ENABLE);
    }
}
