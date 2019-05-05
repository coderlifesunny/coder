package com.dmall.coder.thread.communication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Description: 线程事件处理
 *
 * @Author Guangcai.xu
 * @Date 2019/1/29 9:42
 */
@Data
@Slf4j
public class EventQueue {

    private static final int DEFAULT_MAX_EVENT = 10;

    private int max;

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Event {
        private String ele;
    }

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    /**
     * 往队列里面放数据
     */
    public void offer(Event ele) {
        synchronized (eventQueue) {
            try {
                while (eventQueue.size() >= max) {
                    log.warn("队列已满，请稍后再试试~");
                    eventQueue.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            eventQueue.addLast(ele);
            eventQueue.notifyAll();
            log.info("size:" + eventQueue.size() + "成功添加元素：" + ele.getEle());
        }
    }

    /**
     * 取队列元素
     *
     * @return
     */
    public Event take() {
        synchronized (eventQueue) {
            try {
                while (eventQueue.isEmpty()) {
                    log.warn("队列为空，请稍后再试~");
                    eventQueue.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Event event = eventQueue.removeFirst();
            eventQueue.notifyAll();
            log.info("size:" + eventQueue.size() + "成功取出元素：" + event.getEle());
            return event;
        }
    }

    public static void main(String[] args) {
        EventQueue queue = new EventQueue();
        new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; ++i) {
                queue.offer(new Event(String.valueOf(i)));
            }
        }, "Product").start();

        new Thread(() -> {
            for (; ; ) {
                queue.take();

                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }


}