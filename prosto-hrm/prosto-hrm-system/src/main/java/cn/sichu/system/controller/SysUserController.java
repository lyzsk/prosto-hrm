package cn.sichu.system.controller;

import cn.sichu.common.api.Result;
import cn.sichu.model.SysUser;
import cn.sichu.system.dto.SysUserLoginParam;
import cn.sichu.system.dto.SysUserRegisterParam;
import cn.sichu.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author sichu
 * @date 2023/01/17
 **/
@RestController
@RequestMapping(value = "/sys")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("hello world!");
    }

    /**
     * 用户登录controller
     *
     * @return SysUser对象作为data, 通过gateway把token返回前端
     */
    @PostMapping(value = "/login")
    public Result<SysUser> login(@RequestBody SysUserLoginParam param) {
        int result = sysUserService.login(param.getUsername(), param.getPassword());
        if (result != 1) {
            return Result.failed("login fail!");
        }
        SysUser sysUser = sysUserService.getSysUserByUsername(param.getUsername());
        return Result.success(sysUser, "login success!");
    }

    /**
     * 用户注册controller
     *
     * @return SysUser对象
     */
    @PostMapping(value = "/register")
    public Result<SysUser> register(@RequestBody SysUserRegisterParam param) {
        int result = sysUserService.register(param);
        if (result != 1) {
            return Result.failed("注册失败!");
        }
        SysUser sysUser = sysUserService.getSysUserByUsername(param.getUsername());
        return Result.success(sysUser, "注册成功!");
    }
}
