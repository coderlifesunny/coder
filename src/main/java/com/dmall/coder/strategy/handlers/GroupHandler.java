package com.dmall.coder.strategy.handlers;

import com.dmall.coder.strategy.AbstractHandler;
import com.dmall.coder.strategy.HandlerType;
import com.dmall.coder.strategy.biz.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * Description: 团购订单处理器
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:50
 */
@Component
@HandlerType(2)
public class GroupHandler extends AbstractHandler {

    @Override
    public Object handle(OrderDTO orderDTO) {
        return "处理团购订单啦";
    }
}