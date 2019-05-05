package com.dmall.coder.strategy.biz;

import lombok.Data;

/**
 * Description: 订单实体
 *
 * @Author Guangcai.xu
 * @Date 2019/4/17 13:44
 */
@Data
public class OrderDTO {

    //订单类型
    private Integer type;

    //订单信息
    private String other;

    public OrderDTO(Integer type) {
        this.type = type;
    }
}