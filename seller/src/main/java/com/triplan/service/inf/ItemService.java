package com.triplan.service.inf;

import com.triplan.domain.ItemVO;
import com.triplan.dto.seller.response.ItemDTO;

import java.util.List;

public interface ItemService {

    void itemSave(ItemVO itemVO);

    ItemVO itemRead(Integer itemId);

    void itemModify(Integer itemId, ItemVO itemVO);

    void itemRemove(Integer itemId);

    Integer countItem(Integer sellerId);

    List<ItemDTO> itemList(Integer itemId);

    List<ItemVO> itemListBySellerId(Integer sellerId);
}
