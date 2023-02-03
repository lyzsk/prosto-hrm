package cn.sichu.system;

import cn.sichu.common.constant.Consts;
import cn.sichu.system.dto.SysUserRegisterParam;
import cn.sichu.system.service.SysUserService;
import com.mifmif.common.regex.Generex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author sichu
 * @date 2023/01/18
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testRegister() {
        SysUserRegisterParam param = new SysUserRegisterParam();
        param.setUsername("admin");
        param.setPassword("123456");
        param.setName("Super Admin");
        param.setEmail("admin@gmail.com");
        param.setCountryCode(Consts.CN_CODE);
        Generex generator = new Generex(Consts.CN_MOBILE);
        param.setPhone(generator.random().substring(1, 12));
        int result = sysUserService.register(param);
        System.out.println(result);
    }

    @Test
    public void testLogin() {
        int result = sysUserService.login("admin", "123456");
        System.out.println(result);
    }
}
