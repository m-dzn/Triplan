package com.triplan.service.inf;

import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.RoomCardResponseDTO;
import com.triplan.dto.seller.response.ItemResponseDTO;
import com.triplan.enumclass.ItemCategory;

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
