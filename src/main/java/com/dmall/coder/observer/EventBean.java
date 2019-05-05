package com.dmall.coder.observer;

import lombok.Builder;
import lombok.Data;

/**
 * Description: 事件实体Bean
 *
 * @Author Guangcai.xu
 * @Date 2019/2/11 14:54
 */
@Data
@Builder
public class EventBean {

    private String name;

    private String address;

}