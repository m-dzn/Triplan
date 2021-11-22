package com.triplan.domain.member;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberCouponVO {

    // 식별자 필드
    private Integer memberCouponId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드

    // Default 값이 있는 NOT NULL 필드
    private Boolean usage1;     // default 0(미사용), 1(사용)

    // Nullable 필드
    private LocalDateTime usedAt;

    // 외래키
    private Integer memberId;
    private Integer couponId;
    private Integer resId;      // Nullable, 예약시 기입

}
