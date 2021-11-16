package com.triplan.service.inf;

import com.triplan.domain.ItemVO;
import com.triplan.domain.RoomVO;
import com.triplan.dto.customer.request.ItemFlightRequestDTO;
import com.triplan.dto.customer.request.ItemRoomRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;

import java.util.List;

public interface ItemService {


    ItemVO itemRead(Integer itemId);

    ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId);

    ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId);

    List<ItemRoomResponseDTO> getItemRoomList(ItemCategory room);

    List<ItemFlightResponseDTO> getItemFlightList(ItemCategory flight);
}
