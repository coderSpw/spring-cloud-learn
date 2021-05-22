package com.spw.practice.api.producer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 提供方实体类
 * @Author spw
 * @Date 2021/5/22
 */
@Data
@Entity
@Builder
@Table(name = "tb_producer")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Producer {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    /**
     * 支付金额
     */
    @Digits(message = "金额只允许输入数字", integer = 10, fraction = 2)
    @Column(name = "price",length = 10,scale = 2)
    private BigDecimal price;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payTime;
}
