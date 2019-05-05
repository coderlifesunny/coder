package com.dmall.coder.strategy.handlers;

import com.dmall.coder.strategy.AbstractHandler;
import com.dmall.coder.strategy.HandlerType;
import com.dmall.coder.strategy.biz.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * Description: 正常订单处理器
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:49
 */
@Component
@HandlerType(1)
public class NormalHandler extends AbstractHandler {

    @Override
    public Object handle(OrderDTO orderDTO) {
        return "处理正常订单啦";
    }
}