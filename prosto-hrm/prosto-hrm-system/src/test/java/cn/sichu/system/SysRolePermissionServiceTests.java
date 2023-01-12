package cn.sichu.system;

import cn.sichu.system.dto.SysRolePermissionParam;
import cn.sichu.system.service.SysRolePermissionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author sichu
 * @date 2023/01/12
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SysRolePermissionServiceTests {
    @Autowired
    SysRolePermissionService sysRolePermissionService;

    @Test
    public void testAddSysRolePermission() {
        SysRolePermissionParam sysRolePermissionParam =
            new SysRolePermissionParam(4032601677385728L, 4032868217028608L);
        sysRolePermissionService.addSysRolePermission(sysRolePermissionParam);
    }
}
