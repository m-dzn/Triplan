package com.triplan.service.inf;

import com.triplan.domain.ItemVO;
import com.triplan.domain.RoomVO;
import com.triplan.dto.customer.request.ItemFlightRequestDTO;
import com.triplan.dto.customer.request.ItemRoomRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;

public interface ItemService {

    void itemSave(ItemVO itemVO);

    ItemVO itemRead(Integer itemId);

    void itemModify(Integer itemId, ItemVO itemVO);

    void itemRemove(Integer itemId);

    ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId);

    ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId);

    void insertItemRoom(ItemRoomRequestDTO itemRoomRequestDTO);

    void insertItemFlight(ItemFlightRequestDTO itemFlightRequestDTO);
}
