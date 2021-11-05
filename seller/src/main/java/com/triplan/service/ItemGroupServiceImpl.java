package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import com.triplan.dto.response.ItemResponseDTO;
import com.triplan.dto.response.ItemGroupResponseDTO;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemGroupServiceImpl implements ItemGroupService{

    private final ItemGroupMapper itemGroupMapper;
    private final ItemMapper itemMapper;

    @Override
    public void ItemGroupRegister(ItemGroupVO itemGroupVO) {
        itemGroupMapper.insert(itemGroupVO);
    }

    @Override
    public List<ItemGroupResponseDTO> readSellerIG(Integer sellerId) {
        // 1. sellerId를 가지고 이 판매자의 모든 상품 그룹 (List) 을 가져온다
        List<ItemGroupVO> itemGroups = itemGroupMapper.getListBySellerId(sellerId); // 3

        // 2. 상품 그룹
        List<ItemGroupResponseDTO> response = itemGroups.stream()
                .map(ItemGroupResponseDTO::of).collect(Collectors.toList());
        // ItemGroupResponseDTO :: of 란?
        // 람다식에서 itemGroup -> ItemGroupResponseDTO.of(itemGroup) 처럼
        // 들어오는 매개변수랑 of 매개변수랑 같을 때 :: 을 사용해 처리

        // 3. 각 상품 그룹의 자식 옵션들을 모두 가져온다
        for (ItemGroupResponseDTO itemGroupDTO : response) { // 3
            List<ItemVO> itemList = itemMapper.getListByItemGroupId(itemGroupDTO.getItemGroupId());
            List<ItemResponseDTO> itemDTOList = itemList.stream()
                    .map(ItemResponseDTO::of).collect(Collectors.toList());

            // 3개의 상품 그룹 각각에 자기 자식 item들이 DTO List로 담긴다
            itemGroupDTO.setItemList(itemDTOList);
        }

        // Item Group DTO List 속에 Item DTO List를 싸서 반환한다
        return response;
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

}