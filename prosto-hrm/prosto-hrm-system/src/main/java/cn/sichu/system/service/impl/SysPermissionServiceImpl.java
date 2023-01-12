package cn.sichu.system.service.impl;

import cn.sichu.common.constant.IsDeleted;
import cn.sichu.common.utils.IdWorker;
import cn.sichu.model.SysPermission;
import cn.sichu.system.dao.SysPermissionDao;
import cn.sichu.system.dto.SysPermissionParam;
import cn.sichu.system.service.SysPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/12
 **/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    SysPermissionDao sysPermissionDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void addSysPermission(SysPermissionParam param) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(param, sysPermission);
        Long id = idWorker.nextId();
        sysPermission.setId(id);
        sysPermission.setCode("PERMISSION_" + sysPermission.getName().toUpperCase());
        Date curTime = new Date();
        sysPermission.setCreateTime(curTime);
        sysPermission.setUpdateTime(curTime);
        sysPermission.setIsDeleted(IsDeleted.NO);
        sysPermissionDao.save(sysPermission);
    }
}
