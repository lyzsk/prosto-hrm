package cn.sichu.system.controller;

import cn.sichu.common.api.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sichu
 * @date 2023/01/17
 **/
@RestController
@RequestMapping(value = "/system")
public class TestController {

    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("hello world!");
    }
}
