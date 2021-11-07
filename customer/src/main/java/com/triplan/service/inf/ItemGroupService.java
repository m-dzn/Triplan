package com.triplan.service.inf;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;

public interface ItemGroupService {

    void ItemGroupRegister(ItemGroupVO itemGroupVO);

    ItemGroupVO getItemGroup(Integer itemGroupId);

    void updateItemGroup(ItemGroupVO itemGroupVO, Integer itemGroupId);

    void deleteItemGroup(Integer itemGroupId);

    ItemGroupResponseDTO getItemList(Integer itemGroupId);
}
