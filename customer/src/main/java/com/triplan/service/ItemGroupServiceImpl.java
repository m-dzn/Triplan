package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.mapper.ItemMapper;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemGroupServiceImpl implements ItemGroupService {

    private final ItemGroupMapper itemGroupMapper;
    private final ItemMapper itemMapper;

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

    @Override
    public ItemGroupResponseDTO getItemList(Integer itemGroupId) {

        List<ItemVO> itemVO = itemMapper.getItemByItemGroupId(itemGroupId);

        List<ItemRoomResponseDTO> itemRoomResponseDTO = itemVO.stream()
                .map(ItemRoomResponseDTO::of).collect(Collectors.toList());

        ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

        ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
        itemGroupResponseDTO.setItemList(itemRoomResponseDTO);

        return itemGroupResponseDTO;

    }

}
