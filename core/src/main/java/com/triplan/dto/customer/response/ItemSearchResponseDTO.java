package com.triplan.dto.customer.response;

import com.triplan.domain.ItemVO;

import java.time.LocalDateTime;
import java.util.List;

public class ItemSearchResponseDTO {

    private Integer itemScheduleId;

    private Long price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Integer stock;

    private Long discountPrice;

    private List<ItemVO> itemVO;

}
