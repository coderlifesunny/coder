package com.dmall.coder.strategy.biz;

import com.dmall.coder.strategy.HandlerContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:46
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private HandlerContext handlerContext;

    @Override
    public Object handle(OrderDTO orderDTO) {
        return handlerContext.getInstance(orderDTO.getType()).handle(orderDTO);
    }
}