package com.triplan.service;

import com.triplan.domain.FlightVO;
import com.triplan.domain.ItemVO;
import com.triplan.domain.RoomVO;
import com.triplan.dto.customer.request.ItemFlightRequestDTO;
import com.triplan.dto.customer.request.ItemRoomRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;
import com.triplan.mapper.FlightMapper;
import com.triplan.mapper.ItemMapper;
import com.triplan.mapper.RoomMapper;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final FlightMapper flightMapper;
    private final RoomMapper roomMapper;

    @Override
    public ItemVO itemRead(Integer itemId) {
        return itemMapper.select(itemId);
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
    public List<ItemRoomResponseDTO> getItemRoomList(ItemCategory room) {

        List<ItemVO> itemVOS = itemMapper.getItemVOList(room);

        List<ItemRoomResponseDTO> responseDTOS = itemVOS.stream()
                .map(ItemRoomResponseDTO::of).collect(Collectors.toList());

        for(ItemRoomResponseDTO itemRoomResponseDTO : responseDTOS) {
            RoomVO roomVO = roomMapper.getRoomByItemId(itemRoomResponseDTO.getItemId());

            itemRoomResponseDTO.setRoomVO(roomVO);
        }

        return responseDTOS;
    }

    @Override
    public List<ItemFlightResponseDTO> getItemFlightList(ItemCategory flight) {

        List<ItemVO> itemVOS = itemMapper.getItemVOList(flight);

        List<ItemFlightResponseDTO> responseDTOS = itemVOS.stream()
                .map(ItemFlightResponseDTO::of).collect(Collectors.toList());

        for(ItemFlightResponseDTO itemFlightResponseDTO : responseDTOS) {
            FlightVO flightVO = flightMapper.getFlightByItemId(itemFlightResponseDTO.getItemId());

            itemFlightResponseDTO.setFlightVO(flightVO);
        }

        return responseDTOS;
    }
}
