package cn.sichu.system.service.impl;

import cn.sichu.common.constant.Consts;
import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.constant.Status;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.model.SysUser;
import cn.sichu.system.dto.SysUserRegisterParam;
import cn.sichu.system.repository.SysUserRepository;
import cn.sichu.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/16
 **/
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int login(String username, String password) {
        SysUser sysUser = getSysUserByUsername(username);
        if (sysUser == null) {
            log.info("login获取到的sysuser为null");
            return 0;
        }
        if (!bCryptPasswordEncoder.matches(password, sysUser.getPassword())) {
            log.info("bCryptPasswordEncoder.matches 返回结果为false");
            return 0;
        }
        return 1;
    }

    @Override
    public int register(SysUserRegisterParam param) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(param, sysUser);
        // validate username duplication
        if (getSysUserByUsername(sysUser.getUsername()) != null) {
            return 0;
        }
        Long id = idWorker.nextId();
        sysUser.setId(id);
        // validate password
        String rawPassword = param.getPassword();
        if (rawPassword == null || rawPassword.length() < 6) {
            return 0;
        }
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        sysUser.setPassword(encodedPassword);
        if (param.getAvatar() == null) {
            sysUser.setAvatar(Consts.DEFAULT_AVATAR);
        }
        sysUser.setStatus(Status.ENABLE);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        // TODO: 获取当前用户
        sysUser.setIsDeleted(IsDeleted.NO);
        sysUserRepository.save(sysUser);
        return 1;
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }

    @Override
    public int deleteSysUserById(Long id) {
        try {
            sysUserRepository.deleteById(id);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
