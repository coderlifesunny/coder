package com.dmall.coder.observer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description: 测试类
 *
 * @Author Guangcai.xu
 * @Date 2019/2/11 15:23
 */
@RestController
@RequestMapping("/event/bus")
public class EventBusTest {

    @Resource
    private EventBusAdapter eventBusAdapter;

    @GetMapping("/test1")
    public String test1() {
        eventBusAdapter.post(EventBean.builder().name("徐光财").address("希顿国际广场B座").build());
        return "接口调用成功";
    }
}