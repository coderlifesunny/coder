package com.dmall.coder.strategy;

import com.dmall.coder.strategy.biz.OrderDTO;

/**
 * Description: 抽象处理器
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:46
 */
public abstract class AbstractHandler {
    //处理器方法
    abstract public Object handle(OrderDTO orderDTO);
}