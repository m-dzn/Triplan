package com.triplan.service.inf;

import com.triplan.domain.ItemVO;

public interface ItemService {

    void itemSave(ItemVO itemVO);

    ItemVO itemRead(Integer itemId);

    void itemModify(Integer itemId, ItemVO itemVO);

    void itemRemove(Integer itemId);

}
