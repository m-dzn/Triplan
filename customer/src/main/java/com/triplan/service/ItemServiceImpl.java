package com.triplan.service;

import com.triplan.domain.ItemVO;
import com.triplan.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemMapper itemMapper;

    @Override
    public void itemSave(ItemVO itemVO) {
        itemMapper.itemInsert(itemVO);
    }

    @Override
    public ItemVO itemRead(int itemId) {
        return itemMapper.itemGet(itemId);
    }

    @Override
    public void itemModify(int itemId, ItemVO itemVO) {
        itemVO.setItemId(itemId);
        itemMapper.itemUpdate(itemVO);
    }

    @Override
    public void itemRemove(int itemId) {
        itemMapper.itemDelete(itemId);
    }
}
