package com.triplan.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemScheduleVO extends BaseVO {

    // 식별자 필드
    private Integer itemScheduleId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    @PositiveOrZero
    private Long price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Default 값이 있는 NOT NULL 필드
    @NotBlank
    private Integer stock;

    // Nullable 필드
    @PositiveOrZero
    private Long discountPrice;

    // 외래키
    @NotBlank
    private Integer itemId;

}
