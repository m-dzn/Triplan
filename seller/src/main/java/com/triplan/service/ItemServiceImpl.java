package com.triplan.service;

import com.triplan.domain.ItemVO;
import com.triplan.dto.seller.response.ItemDTO;
import com.triplan.mapper.ItemMapper;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

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

    @Override
    public Integer countItem(Integer sellerId) {
        return itemMapper.count(sellerId);
    }


    @Override
    public List<ItemDTO> itemList(Integer itemId) {
        List<ItemVO> listVO = itemMapper.getItemList(itemId);
        List<ItemDTO> res = listVO.stream().map(ItemDTO::of).collect(Collectors.toList());
        return res;
    }

    @Override
    public List<ItemVO> itemListBySellerId(Integer sellerId) {
        List<ItemVO> listVO = itemMapper.getItemBySellerId(sellerId);
        return listVO;
    }

}
