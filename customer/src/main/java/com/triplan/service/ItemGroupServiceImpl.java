package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.mapper.ItemGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemGroupServiceImpl implements ItemGroupService{

    private final ItemGroupMapper itemGroupMapper;

    @Override
    public void ItemGroupRegister(ItemGroupVO itemGroupVO) {
        itemGroupMapper.insert(itemGroupVO);
    }

    @Override
    public ItemGroupVO getItemGroup(int num) {
        return itemGroupMapper.read(num);
    }

    @Override
    public void updateItemGroup(ItemGroupVO itemGroupVO,int num) {
        itemGroupVO.setItemGroupId(num);
        itemGroupMapper.update(num);
    }

    @Override
    public void deleteItemGroup(int num) {
        itemGroupMapper.delete(num);
    }

    @Override
    public List<ItemGroupVO> getjoin(int num) {
        return itemGroupMapper.getList(num);
    }
}
