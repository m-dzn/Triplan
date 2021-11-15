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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final FlightMapper flightMapper;
    private final RoomMapper roomMapper;

    @Override
    public void itemRemove(Integer itemId) {
        itemMapper.delete(itemId);
    }

    @Override
    public Integer countItem(Integer sellerId) {
        return itemMapper.count(sellerId);
    }

    @Override
    public List<ItemVO> itemListBySellerId(Integer sellerId) {
        List<ItemVO> listVO = itemMapper.getItemBySellerId(sellerId);
        return listVO;
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
    public String insertItemRoom(ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room) {

        ItemVO itemVO = itemRoomRequestDTO.toItemVO();
        RoomVO roomVO = itemRoomRequestDTO.toRoomVO();

        if(itemVO.getItemCategory().equals(room)) {
            itemMapper.insert(itemVO);
            roomVO.setItemId(itemVO.getItemId());
            roomMapper.insert(roomVO);

            return "ItemCatgory MACTH insert Success";
        }
        else
            return "ItemCatgory MISMACTH insert Fail";

    }

    @Override
    public String insertItemFlight(ItemFlightRequestDTO itemFlightRequestDTO, ItemCategory flight) {

        ItemVO itemVO = itemFlightRequestDTO.toItemVO();
        FlightVO flightVO = itemFlightRequestDTO.toFlightVO();

        if(itemVO.getItemCategory().equals(flight)) {
            itemMapper.insert(itemVO);
            flightVO.setItemId(itemVO.getItemId());
            flightMapper.insert(flightVO);

            return "ItemCatgory MACTH Insert Success";
        }
        else
            return "ItemCatgory MISMACTH Insert Fail";

    }

    @Override
    public String  updateRoomItem(Integer itemId, ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room) {

        ItemVO itemVO = itemRoomRequestDTO.toItemVO();
        RoomVO roomVO = itemRoomRequestDTO.toRoomVO();

        if(itemVO.getItemCategory().equals(room)) {

            itemVO.setItemId(itemId);
            itemMapper.update(itemVO);
            roomVO.setItemId(itemVO.getItemId());
            roomMapper.updateByItemId(roomVO);

            return "ItemCatgory MACTH Update Success";
        }
        else
            return "ItemCatgory MISMACTH Update Fail";

    }

    @Override
    public String updateFlightItem(Integer itemId, ItemFlightRequestDTO itemFlightRequestDTO,ItemCategory flight) {

        ItemVO itemVO = itemFlightRequestDTO.toItemVO();
        FlightVO flightVO = itemFlightRequestDTO.toFlightVO();

        if(itemVO.getItemCategory().equals(flight)) {

            itemVO.setItemId(itemId);
            itemMapper.update(itemVO);
            flightVO.setItemId(itemVO.getItemId());
            flightMapper.updateByItemId(flightVO);

            return "ItemCatgory MACTH Update Success";
        }
        else
            return "ItemCatgory MISMACTH Update Fail";

    }

}
