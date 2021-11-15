package com.triplan.service.inf;

import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.request.ItemFlightRequestDTO;
import com.triplan.dto.customer.request.ItemRoomRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;

import java.util.List;

public interface ItemService {

    void itemRemove(Integer itemId);

    Integer countItem(Integer sellerId);

    List<ItemVO> itemListBySellerId(Integer sellerId);

    ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId);

    ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId);

    String insertItemRoom(ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room);

    String insertItemFlight(ItemFlightRequestDTO itemFlightRequestDTO, ItemCategory flight);

    String updateRoomItem(Integer itemId, ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room);

    String updateFlightItem(Integer itemId, ItemFlightRequestDTO itemFlightRequestDTO, ItemCategory flight);

}
