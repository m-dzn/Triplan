package com.triplan.dto.response.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoomCardResponseDTO {

    // ItemVO의 필드
    private Integer itemId;
    private String name;
    private String explain;
    private Integer baseStock;
    private Integer salesVolume;

    // 기타 컬럼
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer pricePerDay;
    private Integer discountPerDay;
    private Integer totalPrice;
    private Integer totalDiscountPrice;

}
