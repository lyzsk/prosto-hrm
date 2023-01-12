package cn.sichu.system.bo;

import cn.sichu.common.constant.Status;
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
    private final List<String> authorities;

    public SysUserDetails(SysUser sysUser, List<String> authorities) {
        this.sysUser = sysUser;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream().map(str -> new SimpleGrantedAuthority(str)).collect(Collectors.toList());
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
