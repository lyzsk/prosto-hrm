package cn.sichu.system.service.impl;

import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.constant.Status;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.model.SysUser;
import cn.sichu.system.dto.SysUserParam;
import cn.sichu.system.repository.SysUserRepository;
import cn.sichu.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/16
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public int register(SysUserParam param) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(param, sysUser);
        // validate username duplication
        if (getSysUserByUsername(sysUser.getUsername()) != null) {
            return 0;
        }
        Long id = idWorker.nextId();
        sysUser.setId(id);
        // TODO: encode password
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
