package com.dmall.coder.strategy;

import java.lang.annotation.*;

/**
 * Description: 订单业务类型注解（主要为了获取类型）
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:40
 */
@Target({ElementType.TYPE})//作用域（类上）
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {
    int value();
}
