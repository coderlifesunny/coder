package com.dmall.coder.aspect;

import com.dmall.coder.aspect.annotation.LogAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 切面测试的接口
 *
 * @Author Guangcai.xu
 * @Date 2019/1/29 13:17
 */
@RestController
@RequestMapping("/aspect")
public class AspectController {

    @GetMapping("/test1")
    @LogAction(description = "测试第一个test1,前置通知")
    public String test1(@RequestParam String name) {
        Integer.parseInt(name);
        return "前置通知";
    }
}