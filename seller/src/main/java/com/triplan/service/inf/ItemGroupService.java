package com.triplan.service.inf;

import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;

public interface ItemGroupService {

    void deleteItemGroup(Integer itemGroupId);

    ItemGroupResponseDTO getItemList(Integer itemGroupId);

    void ItemGroupRegisterAddTags(ItemGroupRequestDTO itemGroupRequestDTO);

    void updateItemGroupTags(Integer itemGroupId, ItemGroupRequestDTO itemGroupRequestDTO);

}
