package com.dmall.coder.observer;

import com.google.common.eventbus.EventBus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2019/2/11 14:45
 */
@Setter
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class EventBusAdapter extends EventBus implements InitializingBean {

    private List<Listener> listeners;

    /**
     * 容器加载完进行注册
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for(Listener listener : listeners){
            this.register(listener);
        }
    }
}
