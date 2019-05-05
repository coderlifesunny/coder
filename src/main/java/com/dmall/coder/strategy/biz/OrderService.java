package com.dmall.coder.strategy.biz;

/**
 * Description: 订单服务
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:44
 */
public interface OrderService {
    Object handle(OrderDTO orderDTO);
}
