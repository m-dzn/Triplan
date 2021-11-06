package com.triplan.domain;

import com.triplan.enumclass.ItemCategory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReservationVO extends BaseVO {

    // 식별자 필드
    private Long resId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private ItemCategory itemCategory;
    private Long totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String name;
    private String phone;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private Long totalDiscountPrice;

    // 외래키
    private Long memberId;

}
