package com.triplan.service.inf;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;

public interface ItemGroupService {

    ItemGroupVO getItemGroup(Integer itemGroupId);

    ItemGroupResponseDTO getItemList(Integer itemGroupId);
}
