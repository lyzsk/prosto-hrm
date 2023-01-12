package cn.sichu.system;

import cn.sichu.system.dto.SysUserRoleParam;
import cn.sichu.system.service.SysUserRoleService;
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
public class SysUserRoleServiceTests {
    @Autowired
    SysUserRoleService sysUserRoleService;

    @Test
    public void testAddSysUserRole() {
        SysUserRoleParam sysUserRoleParam = new SysUserRoleParam(3901873019015168L, 4032601677385728L);
        sysUserRoleService.addSysUserRole(sysUserRoleParam);
    }
}
