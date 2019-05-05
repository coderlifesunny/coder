package com.dmall.coder.observer;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2019/2/11 15:21
 */
@Component
@Slf4j
public class ChildListener extends Listener {

    @Subscribe
    public void operateEvent(EventBean eventBean) {
        new Handler<EventBean>() {
            @Override
            protected void handle(EventBean event) {
                log.info("接收到的事件信息：{}", event);
            }
        }.invoke(eventBean, "处理信息");
    }
}