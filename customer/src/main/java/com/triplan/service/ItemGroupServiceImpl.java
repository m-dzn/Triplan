package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.mapper.ItemMapper;
import com.triplan.mapper.TagMapper;
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
    private final TagMapper tagMapper;

    @Override
    public ItemGroupVO getItemGroup(Integer itemGroupId) {
        return itemGroupMapper.select(itemGroupId);
    }

    @Override
    public ItemGroupResponseDTO getItemList(Integer itemGroupId) {

        List<ItemVO> itemVO = itemMapper.getItemByItemGroupId(itemGroupId);

        if(itemVO.get(0).getItemCategory().equals(ItemCategory.ROOM)){
            System.out.println("room");
            List<ItemRoomResponseDTO> itemRoomResponseDTO = itemVO.stream()
                    .map(ItemRoomResponseDTO::of).collect(Collectors.toList());

            ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

            ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
            itemGroupResponseDTO.setItemRoomList(itemRoomResponseDTO);
            itemGroupResponseDTO.setTagIdList(tagMapper.getIdList(itemGroupId));

            return itemGroupResponseDTO;
        }
        else if(itemVO.get(0).getItemCategory().equals(ItemCategory.FLIGHT)){
            System.out.println("flight");
            List<ItemFlightResponseDTO> itemFlightResponseDTO = itemVO.stream()
                    .map(ItemFlightResponseDTO::of).collect(Collectors.toList());

            ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

            ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
            itemGroupResponseDTO.setItemFlightList(itemFlightResponseDTO);
            itemGroupResponseDTO.setTagIdList(tagMapper.getIdList(itemGroupId));

            return itemGroupResponseDTO;
        }
        else return null;
    }


}
