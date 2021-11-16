package com.triplan.service.inf;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.response.Pagination;

import java.util.List;

public interface ItemGroupService {

    void deleteItemGroup(Integer itemGroupId);

    ItemGroupResponseDTO getItemList(Integer itemGroupId);

    void ItemGroupRegisterAddTags(ItemGroupRequestDTO itemGroupRequestDTO);

    void updateItemGroupTags(Integer itemGroupId, ItemGroupRequestDTO itemGroupRequestDTO);

    Pagination<ItemGroupVO> itemGroupListBySellerId(Integer sellerId, Integer pageSize, Integer currentPage);
}
