package com.triplan.service.inf;

import com.triplan.dto.response.customer.ItemFlightResponseDTO;
import com.triplan.dto.response.customer.ItemRoomResponseDTO;
import com.triplan.dto.response.customer.RoomCardResponseDTO;
import com.triplan.dto.response.seller.ItemResponseDTO;
import com.triplan.enumclass.item.ItemCategory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ItemService {

    ItemResponseDTO itemRead(Integer itemId);

    ItemResponseDTO itemRead(Integer itemId, LocalDateTime startDate, LocalDateTime endDate);

    ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId);

    ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId);

    List<RoomCardResponseDTO> getItemsByItemGroupId(Integer itemGroupId, LocalDate startDate, LocalDate endDate);

}
