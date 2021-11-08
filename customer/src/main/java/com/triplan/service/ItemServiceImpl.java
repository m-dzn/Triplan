package com.triplan.service;

import com.triplan.domain.ItemVO;
import com.triplan.mapper.ItemMapper;
import com.triplan.service.inf.ItemService;
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
        itemMapper.insert(itemVO);
    }

    @Override
    public ItemVO itemRead(Integer itemId) {
        return itemMapper.select(itemId);
    }

    @Override
    public void itemModify(Integer itemId, ItemVO itemVO) {
        itemVO.setItemId(itemId);
        itemMapper.update(itemVO);
    }

    @Override
    public void itemRemove(Integer itemId) {
        itemMapper.delete(itemId);
    }
}
