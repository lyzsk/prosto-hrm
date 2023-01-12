package cn.sichu.system.service.impl;

import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.constant.Status;
import cn.sichu.common.exception.GlobalException;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.common.utils.RequestUtil;
import cn.sichu.model.SysUser;
import cn.sichu.model.SysUserLoginLog;
import cn.sichu.security.utils.JwtTokenUtil;
import cn.sichu.system.bo.SysUserDetails;
import cn.sichu.system.dao.SysRoleDao;
import cn.sichu.system.dao.SysUserDao;
import cn.sichu.system.dao.SysUserLoginLogDao;
import cn.sichu.system.dao.SysUserRoleDao;
import cn.sichu.system.dto.SysUserParam;
import cn.sichu.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SysUserLoginLogDao sysUserLoginLogDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private SysRoleDao sysRoleDao;

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
    public UserDetails loadUserByUsername(String username) {
        SysUser sysUser = getSysUserByUsername(username);
        if (sysUser != null) {
            List<String> authorities = sysUserRoleDao.getRoleList(sysUser.getId());
            return new SysUserDetails(sysUser, authorities);
        }
        throw new UsernameNotFoundException("用户名或密码错误!");
    }

    @Override
    public String login(String username, String password) {
        String token;
        try {
            /*
             * 1. 根据 username 获取 UserDetails 对象
             * 2. 根据 UserDetails 对象获取 SysUser 对象
             * 3. 根据 SysUser 对象的 id, 通过 SysUserRoleDao 获取 authorities
             * 4. 根据 SysUser 对象和 authorities, new 自定义的 UserDetails 对象 SysUserDetails
             */
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确!");
            }
            if (!userDetails.isEnabled()) {
                throw new GlobalException("账号已禁用!");
            }
            UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            // 添加 login log
            addLoginLog(username);
        } catch (AuthenticationException e) {
            throw new GlobalException("登陆异常: " + e.getMessage());
        }
        return token;
    }

    @Override
    public void addLoginLog(String username) {
        SysUser sysUser = getSysUserByUsername(username);
        if (sysUser == null) {
            return;
        }
        SysUserLoginLog loginLog = new SysUserLoginLog();
        loginLog.setId(new IdWorker().nextId());
        loginLog.setUserId(sysUser.getId());
        loginLog.setLoginTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        sysUserLoginLogDao.save(loginLog);
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
