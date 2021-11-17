package com.triplan.dto;

import com.triplan.domain.CouponVO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {

    private Integer couponId;

    @NotEmpty(message = "name는 필수 값입니다.")
    @Size(min = 2, max = 10, message = "name은 2자 이상 10자 이내로 입력해주십시오.")
    private String name;
    @Positive   // 양수만 가능
    private Integer num;
    @NotNull(message = "price는 필수 값입니다.")
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
