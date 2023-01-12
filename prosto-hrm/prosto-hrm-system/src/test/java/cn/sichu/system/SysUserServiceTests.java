package cn.sichu.system;

import cn.sichu.common.constant.Consts;
import cn.sichu.model.SysUser;
import cn.sichu.system.dto.SysUserParam;
import cn.sichu.system.service.SysUserService;
import com.mifmif.common.regex.Generex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author sichu
 * @date 2023/01/10
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SysUserServiceTests {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testRegister() {
        Generex generator = new Generex(Consts.CN_MOBILE);
        SysUserParam sysUserParam = new SysUserParam();
        sysUserParam.setUsername("admin");
        sysUserParam.setPassword("Admin123!");
        sysUserParam.setName("admin");
        sysUserParam.setEmail("admin@admin.com");
        sysUserParam.setCountryCode(Consts.CN_CODE);
        sysUserParam.setPhone(generator.random().substring(1, 12));
        SysUser sysUser = sysUserService.register(sysUserParam);
        System.out.println(sysUser);
    }

}
