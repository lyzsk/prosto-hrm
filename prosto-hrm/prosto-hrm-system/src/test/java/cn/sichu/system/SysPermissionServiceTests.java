package cn.sichu.system;

import cn.sichu.system.dto.SysPermissionParam;
import cn.sichu.system.service.SysPermissionService;
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
public class SysPermissionServiceTests {
    @Autowired
    SysPermissionService sysPermissionService;

    @Test
    public void testAddSysPermission() {
        SysPermissionParam sysPermissionParam = new SysPermissionParam("all", "all permission", "/*");
        sysPermissionService.addSysPermission(sysPermissionParam);
    }
}
