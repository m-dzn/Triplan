package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.ItemCategory;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.mapper.ItemMapper;
import com.triplan.mapper.ItemSearchMapper;
import com.triplan.mapper.TagMapper;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemGroupServiceImpl implements ItemGroupService {

    private final ItemGroupMapper itemGroupMapper;
    private final ItemMapper itemMapper;
    private final TagMapper tagMapper;
    private final ItemSearchMapper itemSearchMapper;

    @Override
    public ItemGroupVO getItemGroup(Integer itemGroupId) {
        return itemGroupMapper.select(itemGroupId);
    }

    @Override
    public ItemGroupResponseDTO getItemList(Integer itemGroupId) {

        List<ItemVO> itemVO = itemMapper.getItemByItemGroupId(itemGroupId);

        if (itemVO.get(0).getItemCategory().equals(ItemCategory.ROOM)){
            List<ItemRoomResponseDTO> itemRoomResponseDTO = itemVO.stream()
                    .map(ItemRoomResponseDTO::of).collect(Collectors.toList());

            ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

            ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
            itemGroupResponseDTO.setItemRoomList(itemRoomResponseDTO);
            itemGroupResponseDTO.setTagIdList(tagMapper.getIdList(itemGroupId));

            return itemGroupResponseDTO;
        }
        else if(itemVO.get(0).getItemCategory().equals(ItemCategory.FLIGHT)){
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

    @Override
    public Pagination<ItemGroupVO> getFilterAsDate(LocalDateTime startDate, LocalDateTime endDate,
                                             Integer underPrice, Integer overPrice, List<Integer> tags,
                                             String sortType,
                                             Integer pageSize, Integer currentPage) {

        Integer Data = null;

        if(startDate != null) Data = 1;
        else if (endDate != null) Data = 1;
        else if (tags != null) Data = 1;
        else if (underPrice != null) Data = 1;
        else if (overPrice != null) Data = 1;
        else Data = null;
        List<ItemGroupVO> itemGroupVOS = null;
        Integer count = 0;

        if(sortType != null) {
            List<ItemGroupVO> sortItemGroupId = itemSearchMapper.getFilterAndSort(startDate, endDate, underPrice, overPrice, tags,sortType, pageSize, currentPage, Data);
            itemGroupVOS = itemGroupMapper.selectAllSort(sortItemGroupId,sortType);
            count = itemSearchMapper.getCount(startDate, endDate, underPrice, overPrice, tags, Data);

            return new Pagination<>(pageSize,currentPage,count,itemGroupVOS);
        }

        else {
            List<ItemGroupVO> resultItemGroupId = itemSearchMapper.getFilterAsDateDistinct(startDate, endDate, underPrice, overPrice, tags, pageSize, currentPage, Data);
            itemGroupVOS = itemGroupMapper.selectAll(resultItemGroupId);
            count = itemSearchMapper.getCount(startDate, endDate, underPrice, overPrice, tags, Data);

            return new Pagination<>(pageSize, currentPage, count, itemGroupVOS);
        }

    }

}