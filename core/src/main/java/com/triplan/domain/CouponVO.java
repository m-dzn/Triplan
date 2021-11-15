package com.triplan.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CouponVO extends BaseVO {

    // 식별자 필드
    private Integer couponId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String name;
    private Integer num;
    private Long price;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private String condition;
    private LocalDateTime expiredAt;

    // 외래키

}
