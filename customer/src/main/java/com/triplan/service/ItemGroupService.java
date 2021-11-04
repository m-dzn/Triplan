package com.triplan.service;

import com.triplan.domain.ItemGroupVO;

import java.util.List;

public interface ItemGroupService {
    void ItemGroupRegister(ItemGroupVO itemGroupVO);

    ItemGroupVO getItemGroup(int num);

    void updateItemGroup(ItemGroupVO itemGroupVO,int num);

    void deleteItemGroup(int num);

    ItemGroupVO getjoin(int num);
}
