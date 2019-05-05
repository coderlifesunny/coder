package com.dmall.coder.strategy;

import java.util.Map;

/**
 * Description: 处理器上下文，持有不同类型的处理器
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:54
 */
public class HandlerContext {
    private Map<Integer, Class> handlerMap;

    public HandlerContext(Map<Integer, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(Integer type) {
        Class clazz = handlerMap.get(type);
        if (null == clazz) {
            throw new IllegalArgumentException("未找到对应的订单处理器，订单类型：" + type + "非法");
        }
        return (AbstractHandler) BeanTool.getBean(clazz);
    }
}