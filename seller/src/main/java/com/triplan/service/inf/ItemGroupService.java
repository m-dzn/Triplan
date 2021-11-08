package com.triplan.service.inf;

import com.triplan.domain.ItemGroupVO;

public interface ItemGroupService {

    void ItemGroupRegister(ItemGroupVO itemGroupVO);

    ItemGroupVO getItemGroup(Integer itemGroupId);

    void updateItemGroup(ItemGroupVO itemGroupVO, Integer itemGroupId);

    void deleteItemGroup(Integer itemGroupId);

}
