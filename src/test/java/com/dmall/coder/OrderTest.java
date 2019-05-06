package com.dmall.coder;

import com.dmall.coder.strategy.biz.OrderDTO;
import com.dmall.coder.strategy.biz.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 15:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Resource
    private OrderService orderService;

    @Test
    public void testOrderHandler() {
        System.out.println(orderService.handle(new OrderDTO(1)));
        System.out.println(orderService.handle(new OrderDTO(2)));
        System.out.println(orderService.handle(new OrderDTO(3)));
//        System.out.println(orderService.handle(new OrderDTO(4)));
    }

}