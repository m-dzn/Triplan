package com.triplan.service.inf;

import com.triplan.domain.item.ItemGroupVO;
import com.triplan.dto.response.customer.ItemGroupResponseDTO;
import com.triplan.dto.response.customer.AccommodationCardResponseDTO;
import com.triplan.dto.response.Pagination;

import java.time.LocalDateTime;
import java.util.List;

public interface ItemGroupService {

    ItemGroupVO getItemGroup(Integer itemGroupId);

    ItemGroupResponseDTO getItemList(Integer itemGroupId, Integer memberId);

    Pagination<AccommodationCardResponseDTO> getFilterAsDate(LocalDateTime startDate, LocalDateTime endDate,
                                                             Integer underPrice, Integer overPrice, List<Integer> tags,
                                                             String sortType,
                                                             Integer pageSize, Integer currentPage, Integer memberId);
}
