package com.dmall.coder.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: 监听器基类
 *
 * @Author Guangcai.xu
 * @Date 2019/2/11 14:50
 */
@Slf4j
public class Listener {

    public abstract static class Handler<T>{
        /**
         * @param event 要处理的内容，实体
         */
        protected abstract void handle(T event);

        public void invoke(T t, String desc){
            try {
                handle(t);
            } catch (Exception e) {
                log.error("listen event " + desc + " error", e);
            }
        }
    }
}