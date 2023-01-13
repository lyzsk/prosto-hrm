package cn.sichu.system.controller;

import cn.sichu.common.api.Result;
import cn.sichu.model.SysUser;
import cn.sichu.system.dto.SysUserLoginParam;
import cn.sichu.system.dto.SysUserParam;
import cn.sichu.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/01/07
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * @param param SysUserParam
     * @return Result
     */
    @PostMapping(value = "/register")
    public Result<SysUser> register(@RequestBody SysUserParam param) {
        SysUser sysUser = sysUserService.register(param);
        if (sysUser == null) {
            return Result.failed("注册失败!");
        }
        return Result.success(sysUser, "注册成功!");
    }

    @PostMapping(value = "/login")
    public Result<Map<String, String>> login(@RequestBody SysUserLoginParam param) {
        Map<String, String> map = new HashMap<>(1);
        String token = sysUserService.login(param.getUsername(), param.getPassword());
        if (token == null) {
            return Result.failed("用户名或密码错误!");
        }
        map.put("token", token);
        return Result.success(map, "登录成功!");
    }

    @GetMapping(value = "/info")
    public Result<Map<String, String>> getInfo(HttpServletRequest request) {
        String username = sysUserService.getUsernameByRequest(request);
        SysUser sysUser = sysUserService.getSysUserByUsername(username);
        Map<String, String> map = new HashMap<>(4);
        map.put("name", sysUser.getName());
        map.put("avatar", sysUser.getAvatar());
        return Result.success(map, "获取用户信息成功!");
    }

    /**
     * @param id id
     * @return Result
     */
    @GetMapping(value = "/{id}")
    public Result<SysUser> getSysUserById(@PathVariable(value = "id") Long id) {
        SysUser sysUser = sysUserService.getSysUserById(id);
        return Result.success(sysUser, "根据id查询成功!");
    }

    /**
     * @param id id
     * @return Result
     */
    @DeleteMapping(value = "/{id}")
    public Result<Object> deleteSysUserById(@PathVariable(value = "id") Long id) {
        sysUserService.deleteSysUserById(id);
        return Result.success(null, "根据id删除成功!");
    }
}
