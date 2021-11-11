package com.triplan.dto;

import com.triplan.domain.CouponVO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {

    private Integer couponId;

    private String name;
    private Integer num;
    private Long price;

    private String condition;
    private LocalDateTime expiredAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;


    public static CouponDTO of(CouponVO couponVO){
        return CouponDTO.builder()
                .couponId(couponVO.getCouponId())
                .name(couponVO.getName())
                .num(couponVO.getNum())
                .price(couponVO.getPrice())
                .condition(couponVO.getCondition())
                .expiredAt(couponVO.getExpiredAt())
                .createdAt(couponVO.getCreatedAt())
                .updatedAt(couponVO.getUpdatedAt())
                .build();
    }

    public CouponVO toVO() {
        return CouponVO.builder()
                .couponId(couponId)
                .name(name)
                .num(num)
                .price(price)
                .condition(condition)
                .expiredAt(expiredAt)
                .build();
    }


}
