package cn.sichu.system.service.impl;

import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.model.SysUserRole;
import cn.sichu.system.dao.SysUserRoleDao;
import cn.sichu.system.dto.SysUserRoleParam;
import cn.sichu.system.service.SysUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sichu
 * @date 2023/01/09
 **/
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void addSysUserRoleRelation(SysUserRoleParam param) {
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(param, sysUserRole);
        Long id = idWorker.nextId();
        sysUserRole.setId(id);
        sysUserRole.setIsDeleted(IsDeleted.NO);
        sysUserRoleDao.save(sysUserRole);
    }

    @Override
    public void deleteSysUserRoleRelationByUserId(Long userId) {
        sysUserRoleDao.deleteByUserId(userId);
    }

    @Override
    public void deleteSysUserRoleRelationByRoleId(Long roleId) {
        // TODO:
    }
}
