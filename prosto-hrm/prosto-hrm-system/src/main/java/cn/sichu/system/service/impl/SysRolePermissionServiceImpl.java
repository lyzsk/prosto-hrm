package cn.sichu.system.service.impl;

import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.model.SysRolePermission;
import cn.sichu.system.dao.SysRolePermissionDao;
import cn.sichu.system.dto.SysRolePermissionParam;
import cn.sichu.system.service.SysRolePermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/12
 **/
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Autowired
    private SysRolePermissionDao sysRolePermissionDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void addSysRolePermission(SysRolePermissionParam param) {
        SysRolePermission sysRolePermission = new SysRolePermission();
        BeanUtils.copyProperties(param, sysRolePermission);
        Long id = idWorker.nextId();
        sysRolePermission.setId(id);
        Date curTime = new Date();
        sysRolePermission.setCreateTime(curTime);
        sysRolePermission.setUpdateTime(curTime);
        sysRolePermission.setIsDeleted(IsDeleted.NO);
        sysRolePermissionDao.save(sysRolePermission);
    }
}
