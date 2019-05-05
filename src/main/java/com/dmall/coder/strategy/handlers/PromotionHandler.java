package com.dmall.coder.strategy.handlers;

import com.dmall.coder.strategy.AbstractHandler;
import com.dmall.coder.strategy.HandlerType;
import com.dmall.coder.strategy.biz.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * Description: 促销订单处理器
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:52
 */
@Component
@HandlerType(3)
public class PromotionHandler extends AbstractHandler {

    @Override
    public Object handle(OrderDTO orderDTO) {
        return "处理促销订单啦";
    }
}