/**
 * 观察者模式的经典guava实现，eventBus，在spring容器启动时，将要监听的listener注册
 * 在订阅到事件后，需要进行处理的方法上加入@Subscribe注解
 */
package com.dmall.coder.observer;