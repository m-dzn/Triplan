package com.triplan.dto.seller.response;

import com.triplan.domain.ItemScheduleVO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemScheduleDTO {

    //ItemScheduleVO
    private Integer itemScheduleId;
    private Long price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    //ItemVO
    private String name;

    private static ItemScheduleDTO of (ItemScheduleVO vo){
        return ItemScheduleDTO.builder()
                .price(vo.getPrice())
                .startDate(vo.getStartDate())
                .endDate(vo.getEndDate())
                .build();
    }
}