package com.triplan.service;

import com.triplan.domain.item.*;
import com.triplan.dto.response.customer.ItemFlightResponseDTO;
import com.triplan.dto.response.customer.ItemRoomResponseDTO;
import com.triplan.dto.response.customer.RoomCardResponseDTO;
import com.triplan.dto.response.seller.ItemResponseDTO;
import com.triplan.dto.response.seller.ItemScheduleResponseDTO;
import com.triplan.enumclass.item.ItemCategory;
import com.triplan.mapper.item.*;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final ItemGroupMapper itemGroupMapper;
    private final FlightMapper flightMapper;
    private final RoomMapper roomMapper;
    private final ItemScheduleMapper itemScheduleMapper;

    @Override
    public ItemResponseDTO itemRead(Integer itemId) {
        return itemRead(itemId, null, null);
    }

    @Override
    public ItemResponseDTO itemRead(Integer itemId, LocalDateTime startDate, LocalDateTime endDate) {
        ItemVO itemVO = itemMapper.select(itemId);

        ItemResponseDTO itemResponseDTO = ItemResponseDTO.of(itemVO);
        ItemGroupVO itemGroupVO = itemGroupMapper.select(itemVO.getItemGroupId());
        itemResponseDTO.setItemGroup(itemGroupVO);

        if (startDate != null) {
            List<ItemScheduleVO> itemScheduleList = itemScheduleMapper.selectByDate(itemId, startDate, endDate);

            List<ItemScheduleResponseDTO> itemScheduleResponseDTOList = new ArrayList<>();

            Long totalPrice = 0L;
            Long totalDiscount = 0L;
            for (ItemScheduleVO itemScheduleVO : itemScheduleList) {
                itemScheduleResponseDTOList.add(ItemScheduleResponseDTO.of(itemScheduleVO));
                totalPrice += itemScheduleVO.getPrice();
                totalDiscount += itemScheduleVO.getDiscountPrice();
            }

            itemResponseDTO.setItemScheduleList(itemScheduleResponseDTOList);
            itemResponseDTO.setTotalPrice(totalPrice);
            itemResponseDTO.setTotalDiscount(totalDiscount);
        }

        return itemResponseDTO;
    }

    @Override
    public ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId) {

        ItemVO itemVO = itemMapper.getItemByItemId(room,itemId);
        if(Objects.isNull(itemVO)){
            return null;
        }
        RoomVO roomVO = roomMapper.getRoomByItemId(itemId);

        ItemRoomResponseDTO itemRoomResponseDTO = ItemRoomResponseDTO.of(itemVO);
        itemRoomResponseDTO.setRoomVO(roomVO);

        return itemRoomResponseDTO;
    }

    @Override
    public ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId) {
        ItemVO itemVO = itemMapper.getItemByItemId(flight,itemId);
        if(Objects.isNull(itemVO)){
            return null;
        }
        FlightVO flightVO = flightMapper.getFlightByItemId(itemId);

        ItemFlightResponseDTO itemFlightResponseDTO = ItemFlightResponseDTO.of(itemVO);
        itemFlightResponseDTO.setFlightVO(flightVO);

        return itemFlightResponseDTO;
    }

    @Override
    public List<RoomCardResponseDTO> getItemsByItemGroupId(Integer itemGroupId, LocalDate startDate, LocalDate endDate) {
        return itemMapper.getItemsByItemGroupId(itemGroupId, startDate, endDate);
    }

}
