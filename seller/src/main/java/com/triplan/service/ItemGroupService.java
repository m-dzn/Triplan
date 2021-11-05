package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.response.ItemGroupResponseDTO;

import java.util.List;

public interface ItemGroupService {
    void ItemGroupRegister(ItemGroupVO itemGroupVO);

    void updateItemGroup(ItemGroupVO itemGroupVO,int num);

    void deleteItemGroup(int num);

    List<ItemGroupResponseDTO> readSellerIG(Integer sellerId);
}