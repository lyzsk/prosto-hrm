package cn.sichu.system;

import cn.sichu.system.dto.SysRoleParam;
import cn.sichu.system.service.SysRoleService;
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
public class SysRoleServiceTests {
    @Autowired
    SysRoleService sysRoleService;

    @Test
    public void testAddSysRole() {
        SysRoleParam sysRoleParam = new SysRoleParam("admin", "admin role");
        sysRoleService.addSysRole(sysRoleParam);
    }
}
