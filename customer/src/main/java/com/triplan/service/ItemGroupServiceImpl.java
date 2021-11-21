package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.AccommodationCardResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.ItemCategory;
import com.triplan.mapper.*;
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
    private final WishlistMapper wishlistMapper;

    @Override
    public ItemGroupVO getItemGroup(Integer itemGroupId) {
        return itemGroupMapper.select(itemGroupId);
    }

    @Override
    public ItemGroupResponseDTO getItemList(Integer itemGroupId, Integer memberId) {

        List<ItemVO> itemVO = itemMapper.getItemByItemGroupId(itemGroupId);

        if (itemVO.get(0).getItemCategory().equals(ItemCategory.ROOM)){
            List<ItemRoomResponseDTO> itemRoomResponseDTO = itemVO.stream()
                    .map(ItemRoomResponseDTO::of).collect(Collectors.toList());

            ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

            ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
            itemGroupResponseDTO.setItemRoomList(itemRoomResponseDTO);
            itemGroupResponseDTO.setTagList(tagMapper.list(itemGroupId));

            // 회원 로그인 시 찜 여부 조회
            if (memberId != null) {
                itemGroupResponseDTO.setLiked(wishlistMapper.exist(itemGroupId, memberId));
            }

            return itemGroupResponseDTO;
        }
        else if(itemVO.get(0).getItemCategory().equals(ItemCategory.FLIGHT)){
            List<ItemFlightResponseDTO> itemFlightResponseDTO = itemVO.stream()
                    .map(ItemFlightResponseDTO::of).collect(Collectors.toList());

            ItemGroupVO itemGroupVO = itemGroupMapper.getItemGroupByItemGroupId(itemGroupId);

            ItemGroupResponseDTO itemGroupResponseDTO = ItemGroupResponseDTO.of(itemGroupVO);
            itemGroupResponseDTO.setItemFlightList(itemFlightResponseDTO);
            itemGroupResponseDTO.setTagList(tagMapper.list(itemGroupId));

            // 회원 로그인 시 찜 여부 조회
            if (memberId != null) {
                itemGroupResponseDTO.setLiked(wishlistMapper.exist(itemGroupId, memberId));
            }

            return itemGroupResponseDTO;
        }
        else return null;
    }

    @Override
    public Pagination<AccommodationCardResponseDTO> getFilterAsDate(LocalDateTime startDate, LocalDateTime endDate,
                                             Integer underPrice, Integer overPrice, List<Integer> tags,
                                             String sortType,
                                             Integer pageSize, Integer currentPage, Integer memberId) {
        if (tags.isEmpty()) tags = null;

        // 검색 조건 필터링 후 DB에서 ItemGroupDTO 가져오기
        List<AccommodationCardResponseDTO> itemGroupDTOs = itemSearchMapper.getFilterAndSort(startDate, endDate, underPrice, overPrice, tags, sortType, pageSize, currentPage);
        
        // 회원 로그인 시 찜 여부 조회
        if (memberId != null) {
            itemGroupDTOs = itemGroupDTOs.stream().peek(dto -> dto.setLiked(wishlistMapper.exist(dto.getItemGroupId(), memberId))).collect(Collectors.toList());
        }

        Integer count = itemSearchMapper.getCount(startDate, endDate, underPrice, overPrice, tags);

        return new Pagination<>(pageSize,currentPage,count, itemGroupDTOs);
    }

}