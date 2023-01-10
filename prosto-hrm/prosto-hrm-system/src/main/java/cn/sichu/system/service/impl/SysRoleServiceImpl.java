package cn.sichu.system.service.impl;

import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.constant.Status;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.model.SysRole;
import cn.sichu.system.dao.SysRoleDao;
import cn.sichu.system.dto.SysRoleParam;
import cn.sichu.system.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sichu
 * @date 2023/01/09
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void addSysRole(SysRoleParam sysRoleParam) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleParam, sysRole);
        Long id = idWorker.nextId();
        sysRole.setId(id);
        sysRole.setStatus(Status.ENABLE);
        sysRole.setIsDeleted(IsDeleted.NO);
        sysRoleDao.save(sysRole);
    }

    @Override
    public void deleteSysRoleById(Long id) {
        sysRoleDao.deleteById(id);
    }
}
