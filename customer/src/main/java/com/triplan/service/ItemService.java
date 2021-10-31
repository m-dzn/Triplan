package com.triplan.service;

import com.triplan.domain.ItemVO;

public interface ItemService {
    void itemSave(ItemVO itemVO);

    ItemVO itemRead(int itemId);

    void itemModify(int itemId, ItemVO itemVO);

    void itemRemove(int itemId);
}
