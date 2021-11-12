package com.triplan.service.inf;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemScheduleVO;
import com.triplan.domain.ItemVO;

import java.time.LocalDateTime;
import java.util.List;

public interface ItemSearchService {
    List<ItemScheduleVO> getListAll();
    List<ItemGroupVO> getFilterAsDate(LocalDateTime startDate, LocalDateTime endDate, Integer underPrice, Integer overPrice);
}
