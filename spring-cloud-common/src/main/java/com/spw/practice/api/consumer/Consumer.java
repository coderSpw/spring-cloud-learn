package com.spw.practice.api.consumer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 服务消费
 * @Author spw
 * @Date 2021/5/22
 */
@Data
@Entity
@Builder
@Table(name = "tb_consumer")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Consumer {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    /**
     * 支付id
     */
    @Column(name = "pay_id")
    private Integer payId;

    /**
     * 订单号
     */
    @Column(name = "ord_no",length = 32)
    private String ordNo;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
