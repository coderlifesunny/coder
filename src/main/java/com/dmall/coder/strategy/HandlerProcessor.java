package com.dmall.coder.strategy;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Description: 统一策略处理器
 * 1、扫描指定包中标有@HandlerType的类；
 * 2、将注解中的类型值作为key，对应的类作为value，保存在Map中；
 * 3、以上面的map作为构造函数参数，初始化HandlerContext，将其注册到spring容器中；
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 14:03
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.dmall.coder.strategy.handlers";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<Integer, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            Annotation annotation = clazz.getAnnotation(HandlerType.class);
            HandlerType handlerType = (HandlerType) annotation;
            int type = handlerType.value();
            handlerMap.put(type, clazz);
        });
        //初始化context，并注册到spring容器中
        HandlerContext context = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }
}