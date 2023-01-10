package cn.sichu.system.service.impl;

import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.constant.Status;
import cn.sichu.common.exception.GlobalException;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.model.SysUser;
import cn.sichu.security.utils.JwtTokenUtil;
import cn.sichu.system.dao.SysUserDao;
import cn.sichu.system.dto.SysUserParam;
import cn.sichu.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * SysUserService 实现类
 *
 * @author sichu
 * @date 2023/01/07
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public SysUser register(SysUserParam param) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(param, sysUser);
        // 验证 username 是否重复
        if (getSysUserByUsername(sysUser.getUsername()) != null) {
            return null;
        }
        Long id = idWorker.nextId();
        sysUser.setId(id);
        // 验证 password 强度
        String password = sysUser.getPassword();
        // 加密 password
        String encodePassword = passwordEncoder.encode(password);
        sysUser.setPassword(encodePassword);
        // TODO: setAvatar
        sysUser.setStatus(Status.ENABLE);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setIsDeleted(IsDeleted.NO);
        sysUserDao.save(sysUser);
        return sysUser;
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }

    @Override
    public String login(String username, String password) {
        String token;
        try {
            // TODO: 把SpringSecurity提供的UserDetails改成自定义的SysUserDetails
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            if (!userDetails.isEnabled()) {
                throw new GlobalException("账号已禁用!");
            }
            UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            // TODO: 添加 login log
        } catch (AuthenticationException e) {
            throw new GlobalException(e.getMessage());
        }
        return token;
    }

    @Override
    public SysUser getSysUserById(Long id) {
        return sysUserDao.findById(id).orElse(null);
    }

    @Override
    public void deleteSysUserById(Long id) {
        sysUserDao.deleteById(id);
    }
}
