package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemGroupServiceImpl implements ItemGroupService {

    private final ItemGroupMapper itemGroupMapper;

    @Override
    public void ItemGroupRegister(ItemGroupVO itemGroupVO) {
        itemGroupMapper.insert(itemGroupVO);
    }

    @Override
    public ItemGroupVO getItemGroup(Integer itemGroupId) {
        return itemGroupMapper.select(itemGroupId);
    }

    @Override
    public void updateItemGroup(ItemGroupVO itemGroupVO,Integer itemGroupId) {
        itemGroupVO.setItemGroupId(itemGroupId);
        itemGroupMapper.update(itemGroupVO);
    }

    @Override
    public void deleteItemGroup(Integer itemGroupId) {
        itemGroupMapper.delete(itemGroupId);
    }

}
